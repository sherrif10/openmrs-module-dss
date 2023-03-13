package org.openmrs.module.dss.api;

import java.util.List;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SymptomService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	Symptom findSymptomById(Integer symptomId);
	
	/**
	 * Fetch symptoms
	 * 
	 * @return list of symptoms
	 */
	@Transactional(readOnly = true)
	public List<Symptom> retriveAll(List<Symptom> symptom);
	
	/**
	 * Save the current state of symptoms
	 * 
	 * @param symptoms
	 * @return
	 */
	@Transactional(readOnly = true)
	public Symptom saveOrUpdate(Symptom symptoms);
	
	@Transactional(readOnly = true)
	public Symptom Update(Symptom symptoms) throws Exception;
	
	@Transactional(readOnly = true)
	public void deleteAll();
	
	@Transactional(readOnly = true)
	public void purgeSymptoms(Symptom symptoms);
}
