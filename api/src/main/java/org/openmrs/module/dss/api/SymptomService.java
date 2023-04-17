package org.openmrs.module.dss.api;

import java.util.List;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * Defines APIs to add,delete,update symptom
 * @ sharif 
 */
@Service("service")
public interface SymptomService extends OpenmrsService {
	
	/**
	 * Gets a symptom by id
	 * 
	 * @param string
	 * @return
	 */
	@Transactional(readOnly = true)
	Symptom getSymptomById(Integer symptomId);
	
	/**
	 * Fetch symptoms
	 * 
	 * @return list of symptoms
	 */
	@Transactional(readOnly = true)
	public List<Symptom> retriveAll();
	
	/**
	 * Save the current state of symptoms
	 * 
	 * @param symptoms
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public Symptom saveOrUpdate(Symptom symptoms) throws Exception;
	
	@Transactional(readOnly = true)
	public Symptom Update(Symptom symptoms) throws Exception;
	
	@Transactional(readOnly = true)
	public void purgeSymptoms(Symptom symptoms) throws APIException;
	
}
