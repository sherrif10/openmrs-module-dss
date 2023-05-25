/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 * <p/>
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 * <p/>
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.dss.api;

import java.util.List;

import org.openmrs.Patient;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.transaction.annotation.Transactional;

/*
 * Defines APIs to add,delete,update symptom
 * @ sharif 
 */
@Transactional
public interface SymptomService extends OpenmrsService {
	
	/**
	 * Gets a symptom by id Retrive a specific symptom based on its symptomId
	 * 
	 * @param symptomId The ID of the symptom to retrive
	 * @return the symptom which matches the specific ID
	 */
	@Transactional(readOnly = true)
	Symptom getSymptomById(Integer symptomId);
	
	/**
	 * @return list of symptoms the patient triggers
	 */
	@Transactional(readOnly = true)
	public List<Symptom> getAllSymptoms();
	
	@Transactional(readOnly = true)
	public List<Symptom> generateSymptomsForPatient(Patient patient);
	
	/**
	 * Gets a symptom by uuid Retrive a specific symptom based on its symptomId
	 * 
	 * @param symptomId The UUID of the symptom to retrive
	 * @return the symptom which matches the specific uuid
	 */
	public Symptom getSymptomByUuid(String uuid);
	
	/**
	 * Save the current state of symptoms in the database
	 * 
	 * @param symptom the symptom to add or update
	 * @return
	 */
	@Authorized(value = { SymptomConstants.PRIV_MANAGE_SYMPTOM })
	public void saveOrUpdate(Symptom symptoms) throws Exception;
	
	@Transactional(readOnly = true)
	public void purgeSymptoms(Symptom symptom) throws APIException;
	
}
