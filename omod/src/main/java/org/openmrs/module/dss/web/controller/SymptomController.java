package org.openmrs.module.dss.web.controller;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SymptomController {
	
	private static final Log LOGGER = LogFactory.getLog(SymptomController.class);
	
	@Autowired
	SymptomService service;
	
	@RequestMapping(value = "/symptom", method = RequestMethod.GET)
	public String register(Map<String, Object> map) {
		map.put("symptom", new Symptom());
		return "/symptom";
	}
	
	@RequestMapping(value = "/symptom", method = RequestMethod.GET)
	public String create(@RequestParam(value = "symptomId") Symptom symptom) throws Exception {
		symptom = new Symptom();
		symptom.setDiabetes(symptom.getDiabetes());
		symptom.setFever(symptom.getFever());
		symptom.setJointAches(symptom.getJointAches());
		symptom.setJointAches(symptom.getJointAches());
		symptom.setLossOfSmell(symptom.getLossOfSmell());
		symptom.setMuscleAches(symptom.getMuscleAches());
		symptom.setNuesea(symptom.getNuesea());
		symptom.setOccupation(symptom.getOccupation());
		symptom.setOtherNueral(symptom.getOtherNueral());
		symptom.setPainFulBreathing(symptom.getPainFulBreathing());
		symptom.setRash(symptom.getRunnyNose());
		if (symptom != null) {
			LOGGER.info("symptoms getting instantiated");
			symptom.setDescription("symptom is not null");
		}
		service.saveOrUpdate(symptom);
		
		return "redirect:/symptom";
	}
	
	@RequestMapping(value = "/symptom/{symptomId}", method = RequestMethod.GET)
	public String details(@PathVariable("symptomId") Integer symptomId, Map<String, Object> map) {
		Symptom symptom = service.getSymptomById(symptomId);
		map.put("fever", symptom.getFever());
		map.put("occupation", symptom.getOccupation());
		return "symptoms";
		
	}
}
