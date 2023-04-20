package org.openmrs.module.dss.api.impl;

import java.util.List;

import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.dss.api.dao.SymptomDao;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sharif Implementation of the {@link symtomService}
 */
public class SymptomServiceImpl extends BaseOpenmrsService implements SymptomService {
	
	/*Data access object for symptom */
	private SymptomDao symptomDao;
	
	UserService userService;
	
	public void setSymptomDao(SymptomDao symptomDao) {
		this.symptomDao = symptomDao;
	}
	
	@Override
	@Transactional
	public Symptom saveOrUpdate(Symptom symptoms) {
		return symptomDao.saveOrUpdate(symptoms);
	}
	
	public void purgeSymptoms(Symptom symptom) {
		symptomDao.purgeSymptoms(symptom);
	}
	
	@Override
	public Symptom getSymptomById(Integer symptomId) {
		return symptomDao.getSymptomById(symptomId);
	}
	
	public List<Symptom> getAllSymptoms() {
		List<Symptom> symptoms = symptomDao.getAllSymptoms();
		return symptoms;
	}
	
	@Override
	public Symptom getSymptomByUuid(String uuid) {
		return symptomDao.getSymptomByUuid(uuid);
	}
}
