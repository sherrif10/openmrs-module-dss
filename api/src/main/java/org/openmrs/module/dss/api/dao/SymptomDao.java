package org.openmrs.module.dss.api.dao;

import java.io.Serializable;
import java.util.List;

import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SymptomDao extends Serializable {
	
	/**
	 * Find a symptom using the symptom id
	 * 
	 * @param symptomId
	 * @return the symptom object
	 */
	@Transactional(readOnly = true)
	Symptom findSymptomById(Integer symptomId);
	
	@Transactional(readOnly = true)
	public List<Symptom> retriveAll(List<Symptom> symptom);
	
	@Transactional(readOnly = true)
	public Symptom saveOrUpdate(Symptom symptoms);
	
	public Symptom Update(Symptom symptoms);
	
	@Transactional(readOnly = true)
	public void deleteAll();
	
	@Transactional(readOnly = true)
	public void purgeSymptoms(Symptom symptoms);
	
}
