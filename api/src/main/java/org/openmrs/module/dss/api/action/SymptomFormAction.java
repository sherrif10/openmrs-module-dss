package org.openmrs.module.dss.api.action;

import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.EncounterService;

import org.openmrs.api.context.Context;
import org.openmrs.module.htmlformentry.CustomFormSubmissionAction;
import org.openmrs.module.htmlformentry.FormEntrySession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SymptomFormAction implements CustomFormSubmissionAction {

    private EncounterService encounterService;

    private static final String TEST_CLASS = "Test";
    private static final Integer DESTINATION_CONCEPT_ID = 166111;
    private static final String AIMODEL_DESTINATION = "AI END POINT URL";

    private Log log = LogFactory.getLog(this.getClass());

   
    @Override
    public void applyAction(FormEntrySession formSession) {
        Encounter symptomEncounter = formSession.getEncounter();
    
        encounterService = Context.getEncounterService();
    
        Optional<Obs> destinationObs = symptomEncounter.getObs().stream()
                .filter(obs -> obs.getConcept().getConceptId().equals(DESTINATION_CONCEPT_ID)).findFirst();
        if (destinationObs.isPresent()) {
            if (destinationObs.get().getValueText().equals(AIMODEL_DESTINATION)) {
                Set<Concept> testConcepts = new HashSet<Concept>();
                List<Obs> capturedObsList = new ArrayList<>();
    
                symptomEncounter.getObs().forEach(obs -> {
                    if (obs.getValueCoded() != null) {
                        if (obs.getValueCoded().getConceptClass().getName().equals(TEST_CLASS)) {
                            testConcepts.add(obs.getValueCoded());
                        }
                    }
                    capturedObsList.add(obs); // Add the observed value to the list of captured observations
                });
    
                Encounter newEncounter = new Encounter();
                newEncounter.setPatient(symptomEncounter.getPatient());
                newEncounter.setLocation(symptomEncounter.getLocation());
                newEncounter.setEncounterProviders(symptomEncounter.getActiveEncounterProviders());
                newEncounter.setEncounterDatetime(symptomEncounter.getEncounterDatetime());
                newEncounter.setEncounterType(symptomEncounter.getEncounterType());
                encounterService.saveEncounter(newEncounter);
    
                // Return the list of captured observations
                for (Obs capturedObs : capturedObsList) {
                    log.info("Captured Obs: " + capturedObs.getConcept().getName().getName());
                }
            }
        }
    }
}
