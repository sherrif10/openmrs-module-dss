package org.openmrs.module.dss.api.dao;

import java.util.List;

import org.openmrs.api.db.DAOException;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is DAO For symtom entity.
 */
public interface SymptomDao {
	
	/**
	 * Find a symptom using the symptom id
	 * 
	 * @param symptomId
	 * @return the symptom object
	 */
	@Transactional(readOnly = true)
	Symptom getSymptomById(Integer symptomId);
	
	/**
	 * Saves a Symptom in the dss symptom table
	 * 
	 * @param symptom symptom to save
	 * @throws DAOException
	 */
	@Transactional(readOnly = true)
	public void saveOrUpdate(Symptom symptoms) throws DAOException;
	
	/**
	 * Remove a Symptom from the dss symptom table
	 * 
	 * @param symptomId the symptomId of the Symptom to remove
	 * @throws DAOException
	 */
	@Transactional(readOnly = true)
	public void purgeSymptoms(Symptom symptom);
	
	/**
	 * Get all the Patients Symptoms in the Symptom table
	 * 
	 * @return a list of all Patient Symptom in the Symptom table
	 * @throws DAOException
	 */
	public List<Symptom> getAllSymptoms() throws DAOException;
	
	/**
	 * Get symptom by uuid
	 * 
	 * @param uuid
	 * @return
	 * @throws DAOException
	 */
	public Symptom getSymptomByUuid(String uuid) throws DAOException;
	
	/**
	 * Checks if given symptom's name is duplicated
	 * 
	 * @param symptom object to verify uniqueness of symptom name
	 * @return true or false depending on symptom's name is duplicated or not
	 */
	boolean isSymptomNameDuplicated(Symptom symptom);
	
}
