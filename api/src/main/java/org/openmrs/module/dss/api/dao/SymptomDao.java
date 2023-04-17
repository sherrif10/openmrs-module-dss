package org.openmrs.module.dss.api.dao;

import java.util.List;

import org.openmrs.api.db.OpenmrsMetadataDAO;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is DAO For symtom entity.
 */
public interface SymptomDao extends OpenmrsMetadataDAO<Symptom> {
	
	/**
	 * Find a symptom using the symptom id
	 * 
	 * @param symptomId
	 * @return the symptom object
	 */
	@Transactional(readOnly = true)
	Symptom getSymptomById(Integer symptomId);
	
	@Transactional(readOnly = true)
	List<Symptom> retriveAll();
	
	@Transactional(readOnly = true)
	public Symptom saveOrUpdate(Symptom symptoms);
	
	public Symptom Update(Symptom symptoms);
	
	@Transactional(readOnly = true)
	public void purgeSymptoms(Symptom symptoms);
	
	Symptom findByFeverAndNuesea(String fever, String nuesea);
	
}
