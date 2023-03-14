package org.openmrs.module.dss.api.impl;

import java.util.List;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.dss.api.dao.SymptomDao;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SymptomServiceImpl extends BaseOpenmrsService implements SymptomService {
	
	private SymptomDao symptomDao;
	
	public void setSymptomDao(SymptomDao symptomDao) {
		this.symptomDao = symptomDao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Symptom findSymptomById(Integer symptomId) {
		return symptomDao.findSymptomById(symptomId);
	}
	
	@Override
	@Transactional
	public List<Symptom> retriveAll(List<Symptom> symptom) {
		return symptomDao.retriveAll(symptom);
	}
	
	@Override
	@Transactional
	public Symptom saveOrUpdate(Symptom symptoms) {
		return symptomDao.saveOrUpdate(symptoms);
	}
	
	@Override
	public Symptom Update(Symptom symptoms) throws Exception {
		symptoms = symptomDao.findSymptomById(symptoms.getId());
		if (null == symptoms) {
			throw new IllegalArgumentException("Invalid symptoms {} " + symptoms);
		}
		symptoms.setDiabetes(symptoms.getDiabetes());
		symptoms.setFever(symptoms.getFever());
		symptoms.setJointAches(symptoms.getLossOfSmell());
		symptoms.setLossOfSmell(symptoms.getLossOfSmell());
		symptoms.setMuscleAches(symptoms.getMuscleAches());
		symptoms.setNuesea(symptoms.getNuesea());
		symptoms.setOccupation(symptoms.getOccupation());
		symptoms.setOtherNueral(symptoms.getOtherNueral());
		symptoms.setPainFulBreathing(symptoms.getPainFulBreathing());
		symptoms.setRash(symptoms.getRash());
		symptoms.setRelationshipWithContactPerson(symptoms.getRelationshipWithContactPerson());
		symptoms.setRunnyNose(symptoms.getRunnyNose());
		symptoms.setShortnessOfBreath(symptoms.getShortnessOfBreath());
		symptoms.setSoreThroats(symptoms.getSoreThroats());
		
		if (null == symptoms.getId()) {
			symptoms.setId(symptoms.getId());
		}
		return symptomDao.Update(symptoms);
	}
	
	@Override
	public void deleteAll() {
		symptomDao.deleteAll();
	}
	
	@Override
	public void purgeSymptoms(Symptom symptoms) {
		symptomDao.purgeSymptoms(symptoms);
	}
	
}
