package org.openmrs.module.dss.web.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.dss.api.model.Symptom;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.springframework.stereotype.Controller;

@Controller
public class SymptomController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	public void controller(FragmentModel model, @FragmentParam("patientId") Patient patient) {
		model.addAttribute("patientId", patient.getPatientId());
	}
	
	public List<Symptom> generatePatientSymptoms(@FragmentParam("patientId") Patient patient) {
		SymptomService symptomService = Context.getService(SymptomService.class);
		List<Symptom> listAllSymptom = symptomService.getAllSymptoms();
		StringBuilder symptomString = new StringBuilder();
		
		for (Symptom symptom : listAllSymptom) {
			SimpleObject simpleObject = new SimpleObject();
			symptom.getId();
			simpleObject.put("symptom", symptomString);
		}
		return listAllSymptom;
		
	}
	
}
