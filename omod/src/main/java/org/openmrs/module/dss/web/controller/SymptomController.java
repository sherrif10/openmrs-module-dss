package org.openmrs.module.dss.web.controller;

import org.openmrs.module.dss.api.model.Symptom;
import org.openmrs.ui.framework.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/dss")
public class SymptomController {
	
	@RequestMapping(value = "/dss/Create", method = RequestMethod.POST)
	public Symptom createSymptoms(Model model) {
		return null;
	}
	
}
