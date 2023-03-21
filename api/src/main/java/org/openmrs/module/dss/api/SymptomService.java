package org.openmrs.module.dss.api;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SymptomService extends OpenmrsService {
	
	/**
	 * Gets a symptom by id.
	 * 
	 * @param id symptomId - the id of the symptom to retrieve.
	 * @return {@link org.openmrs.module.dss.model.symptom}
	 */
	@Transactional(readOnly = true)
	Symptom findSymptomById(Integer symptomId);
	
	/**
	 * Fetch symptoms
	 * 
	 * @param object
	 * @return list of symptoms
	 */
	@Transactional(readOnly = true)
	public List<Symptom> retriveAll(Symptom symptom);
	
	/**
	 * Save the current state of symptoms
	 * 
	 * @param dss the symptoms to be saved
	 * @return saved {@link org.openmrs.module.dss.model.symptom}
	 */
	@Transactional(readOnly = true)
	public Symptom saveOrUpdate(Symptom symptoms);
	
	@Transactional(readOnly = true)
	public void deleteAll();
	
	/**
	 * Completely remove a symptom from the database
	 * 
	 * @param symptom symptom to be deleted
	 * @throws APIException <strong>Should</strong> delete the given symptom from the database
	 */
	@Transactional(readOnly = true)
	public void purgeSymptoms(Symptom symptoms);
	
	Optional<Symptom> getByUniqueId(@NotNull String uniqueId) throws APIException;
	
}
