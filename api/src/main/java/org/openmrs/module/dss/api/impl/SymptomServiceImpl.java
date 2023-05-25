package org.openmrs.module.dss.api.impl;

import java.util.List;

import org.openmrs.Patient;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.dss.api.dao.SymptomDao;
import org.openmrs.module.dss.api.model.Symptom;

/**
 * @author sharif
 */
public class SymptomServiceImpl extends BaseOpenmrsService implements SymptomService {
	
	/*Data access object for the Symptom */
	private SymptomDao symptomDao;
	
	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setSymptomDao(SymptomDao symptomDao) {
		this.symptomDao = symptomDao;
	}
	
	public List<Symptom> generateSymptomPatient(Patient patient) {
		return generateSymptomPatient(patient);
	}
	
	public void saveOrUpdate(Symptom symptom) {
		//add the symptom to the DB table
		this.symptomDao.saveOrUpdate(symptom);
	}
	
	public void purgeSymptoms(Symptom symptom) {
		//remove the symptom from the DB table
		symptomDao.purgeSymptoms(symptom);
	}
	
	@Override
	public Symptom getSymptomById(Integer symptomId) {
		return symptomDao.getSymptomById(symptomId);
	}
	
	public List<Symptom> getAllSymptoms() {
		return symptomDao.getAllSymptoms();
	}
	
	@Override
	public Symptom getSymptomByUuid(String uuid) {
		return symptomDao.getSymptomByUuid(uuid);
	}
	
	@Override
	public List<Symptom> generateSymptomsForPatient(Patient patient) {
		throw new UnsupportedOperationException("Unimplemented method 'generateSymptomsForPatient'");
	}
	
}
