package org.openmrs.module.dss.api.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.dss.api.dao.SymptomDao;
import org.openmrs.module.dss.api.model.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SymptomDaoImpl implements SymptomDao {
	
	@Autowired
	DbSessionFactory dbSessionFactory;
	
	public void setDbSessionFactory(DbSessionFactory dbSessionFactory) {
		this.dbSessionFactory = dbSessionFactory;
	}
	
	private Class mappedClass;
	
	public SymptomDaoImpl() {
		this.mappedClass = Symptom.class;
	}
	
	@Override
	public Symptom findSymptomById(Integer symptomId) {
		Object result = getSession().get(this.mappedClass, symptomId);
		return result != null ? (Symptom) result : null;
	}
	
	@Override
	public List<Symptom> retriveAll(List<Symptom> symptom) {
		Criteria crit = getSession().createCriteria(this.mappedClass);
		if (symptom != null) {
			crit.add(Restrictions.eq("voided", false));
		}
		return crit.list();
	}
	
	@Override
	public Symptom saveOrUpdate(Symptom symptoms) {
		getSession().saveOrUpdate(symptoms);
		return symptoms;
	}
	
	@Override
	public Symptom Update(Symptom symptoms) {
		getSession().update(symptoms);
		getSession().flush();
		return symptoms;
	}
	
	@Override
	public void deleteAll() {
		getSession().createQuery("delete from dss_symtom").executeUpdate();
	}
	
	@Override
	public void purgeSymptoms(Symptom symptoms) {
		getSession().delete(symptoms);
	}
	
	private DbSession getSession() {
		return dbSessionFactory.getCurrentSession();
	}
	
}
