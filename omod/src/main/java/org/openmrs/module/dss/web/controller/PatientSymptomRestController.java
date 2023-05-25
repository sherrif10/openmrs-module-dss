package org.openmrs.module.dss.web.controller;

import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + PatientSymptomRestController.PATIENT_SYMPTOM_REST_NAMESPACE)
public class PatientSymptomRestController extends MainResourceController {
	
	public static final String PATIENT_SYMPTOM_REST_NAMESPACE = "/symptom";
	
	@Override
	public String getNamespace() {
		return RestConstants.VERSION_1 + PATIENT_SYMPTOM_REST_NAMESPACE;
	}
}
