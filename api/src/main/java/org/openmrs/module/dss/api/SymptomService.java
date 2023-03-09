package org.openmrs.module.dss.api;

import java.util.List;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.dss.api.model.Symptom;

public interface SymptomService extends OpenmrsService {
	
	Symptom findSymptomById(Integer symptomId);
	
	/**
	 * Fetch symptoms
	 * 
	 * @return list of symptoms
	 */
	public List<Symptom> retriveAll(List<Symptom> symptom);
	
	/**
	 * Save the current state of symptoms
	 * 
	 * @param symptoms
	 * @return
	 */
	public Symptom saveOrUpdate(Symptom symptoms);
	
	public Symptom Update(Symptom symptoms) throws Exception;
	
	public void deleteAll();
	
	public void purgeSymptoms(Symptom symptoms);
}
