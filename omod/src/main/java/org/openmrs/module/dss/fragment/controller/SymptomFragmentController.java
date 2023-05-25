package org.openmrs.module.dss.fragment.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.dss.api.model.Symptom;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.fragment.FragmentModel;

public class SymptomFragmentController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	public void controller(FragmentModel model, @FragmentParam("patientId") Patient patient) {
		model.addAttribute("patientId", patient.getPatientId());
	}
	
	public SimpleObject generatePatientSymptoms(@FragmentParam("patientId") Patient patient) {
		SymptomService symptomService = Context.getService(SymptomService.class);
		List<Symptom> listAllSymptom = symptomService.getAllSymptoms();
		StringBuilder symptomString = new StringBuilder();
		
		for (Symptom symptom : listAllSymptom) {
			SimpleObject simpleObject = new SimpleObject();
			symptom.getId();
			simpleObject.put("", symptomString);
		}
		return null;
		
	}
}
