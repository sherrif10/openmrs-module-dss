package org.openmrs.module.dss.api.builder;

import org.openmrs.module.dss.api.model.Symptom;

public class SymptomRequestBuilder {
	
	public Symptom createFrom(Symptom symptom) {
		
		Symptom symptom2 = new Symptom();
		symptom2.setId(symptom.getId());
		symptom2.setFever(symptom.getFever());
		symptom2.setDiabetes(symptom.getDiabetes());
		symptom2.setJointAches(symptom.getJointAches());
		symptom2.setLossOfSmell(symptom.getLossOfSmell());
		symptom2.setMuscleAches(symptom.getMuscleAches());
		symptom2.setNuesea(symptom.getNuesea());
		symptom2.setOccupation(symptom.getOccupation());
		symptom2.setOtherNueral(symptom.getOtherNueral());
		symptom2.setPainFulBreathing(symptom.getPainFulBreathing());
		symptom2.setRash(symptom.getRash());
		symptom2.setRelationshipWithContactPerson(symptom.getRelationshipWithContactPerson());
		symptom2.setRunnyNose(symptom.getRunnyNose());
		symptom2.setShortnessOfBreath(symptom.getShortnessOfBreath());
		symptom2.setSoreThroats(symptom.getSoreThroats());
		return symptom2;
	}
	
}
