package org.openmrs.module.dss.api.impl;

import java.util.List;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.dss.api.dao.SymptomDao;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sharif
 */
public class SymptomServiceImpl extends BaseOpenmrsService implements SymptomService {
	
	@Autowired
	private SymptomDao symptomDao;
	
	public void setSymptomDao(SymptomDao symptomDao) {
		this.symptomDao = symptomDao;
	}
	
	@Override
	@Transactional
	public Symptom saveOrUpdate(Symptom symptoms) throws Exception {
		return symptomDao.saveOrUpdate(symptoms);
	}
	
	@Override
	public Symptom Update(Symptom symptoms) throws Exception {
		return symptomDao.Update(symptoms);
	}
	
	@Override
	public void purgeSymptoms(Symptom symptoms) {
		symptomDao.purgeSymptoms(symptoms);
	}
	
	/**
	 * @see org.openmrs.module.dss.api.SymptomService#retrieve(org.openmrs.module.symptom.model.Symptom)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Symptom> retriveAll() {
		return symptomDao.retriveAll();
	}
	
	@Override
	public Symptom getSymptomById(Integer symptomId) {
		return symptomDao.getSymptomById(symptomId);
	}
	
}
