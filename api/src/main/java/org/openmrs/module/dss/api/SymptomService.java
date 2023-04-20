package org.openmrs.module.dss.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SymptomService extends OpenmrsService {
	
	/**
	 * Gets a symptom by id
	 * 
	 * @param string
	 * @return
	 */
	@Transactional(readOnly = true)
	Symptom getSymptomById(Integer symptomId);
	
	@Transactional(readOnly = true)
	public List<Symptom> getAllSymptoms();
	
	public Symptom getSymptomByUuid(String uuid);
	
	/**
	 * Adds or updates a specific flag in the database
	 * 
	 * @param symptoms the symptom to add or update
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public Symptom saveOrUpdate(Symptom symptoms);
	
	@Transactional(readOnly = true)
	public void purgeSymptoms(Symptom symptom);
	
}
