package org.openmrs.module.dss.api.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.dss.api.dao.SymptomDao;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("symptomDao")
public class SymptomDaoImpl implements SymptomDao {
	
	/**
	 * Hibernate session factory
	 */
	DbSessionFactory dbSessionFactory;
	
	/**
	 * set session factory
	 * 
	 * @param dbSessionFactory
	 */
	public void setDbSessionFactory(DbSessionFactory dbSessionFactory) {
		this.dbSessionFactory = dbSessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Symptom> getAllSymptoms() throws DAOException {
		Criteria criteria = dbSessionFactory.getCurrentSession().createCriteria(Symptom.class);
		return (List<Symptom>) criteria.list();
	}
	
	public Symptom getSymptomById(Integer symptomId) {
		return (Symptom) dbSessionFactory.getCurrentSession().get(Symptom.class, symptomId);
	}
	
	public Symptom getSymptomByUuid(String uuid) throws DAOException {
		return (Symptom) this.dbSessionFactory.getCurrentSession().createQuery("from dss_symptom d where d.uuid = :uuid")
		        .setString("uuid", uuid).uniqueResult();
	}
	
	public void saveOrUpdate(Symptom symptom) throws DAOException {
		dbSessionFactory.getCurrentSession().saveOrUpdate(symptom);
	}
	
	public void purgeSymptoms(Symptom symptom) throws DAOException {
		dbSessionFactory.getCurrentSession().delete(symptom);
	}
	
	@Override
	@Transactional
	public boolean isSymptomNameDuplicated(Symptom symptom) {
		Criteria criteria = dbSessionFactory.getCurrentSession().createCriteria(Symptom.class);
		addEqualsRestriction(criteria, "fever", symptom.getFever());
		addNotEqualsRestriction(criteria, "symptomId", symptom.getId());
		
		return criteria.uniqueResult() != null;
		
	}
	
	private void addEqualsRestriction(Criteria criteria, String propertyName, Object value) {
		if (value != null) {
			criteria.add(Restrictions.eq(propertyName, value));
		}
	}
	
	private void addNotEqualsRestriction(Criteria criteria, String propertyName, Object value) {
		if (value != null) {
			criteria.add(Restrictions.not(Restrictions.eq(propertyName, value)));
		}
	}
	
}
