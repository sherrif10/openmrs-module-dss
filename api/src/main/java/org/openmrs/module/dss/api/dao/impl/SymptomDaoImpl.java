package org.openmrs.module.dss.api.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.api.db.hibernate.HibernateOpenmrsMetadataDAO;
import org.openmrs.module.dss.api.dao.SymptomDao;
import org.openmrs.module.dss.api.model.Symptom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("symptomDao")
public class SymptomDaoImpl extends HibernateOpenmrsMetadataDAO<Symptom> implements SymptomDao {
	
	private static final Logger logger = LoggerFactory.getLogger(SymptomDaoImpl.class);
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	DbSessionFactory dbSessionFactory;
	
	public void setDbSessionFactory(DbSessionFactory dbSessionFactory) {
		this.dbSessionFactory = dbSessionFactory;
	}
	
	public SymptomDaoImpl() {
		super(Symptom.class);
	}
	
	@Override
	public Symptom getSymptomById(Integer symptomId) {
		return (Symptom) sessionFactory.getCurrentSession().get(Symptom.class, symptomId);
	}
	
	@Override
	public Symptom saveOrUpdate(Symptom symptoms) {
		sessionFactory.getCurrentSession().saveOrUpdate(symptoms);
		logger.info("Symptom saved successfully, Symptom details=" + symptoms);
		return symptoms;
	}
	
	@Override
	public Symptom Update(Symptom symptoms) {
		sessionFactory.getCurrentSession().update(symptoms);
		logger.info("Symptom Updated successfully, Symptom Details=" + symptoms);
		return symptoms;
	}
	
	@Override
	public void purgeSymptoms(Symptom symptoms) {
		Symptom symptom = (Symptom) sessionFactory.getCurrentSession().load(mappedClass, new Symptom());
		if (null != symptom) {
			sessionFactory.getCurrentSession().delete(symptom);
		}
		logger.info("Symptom purged successfully, Symptom details=" + symptom);
		sessionFactory.getCurrentSession().delete(symptoms);
	}
	
	private DbSession getSession() {
		return dbSessionFactory.getCurrentSession();
	}
	
	@Override
	public Symptom findByFeverAndNuesea(String fever, String nuesea) {
		Criteria crit = getSession().createCriteria(this.mappedClass);
		crit.add(Restrictions.eq("fever", fever));
		crit.add(Restrictions.eq("Nuesea", nuesea));
		return (Symptom) crit.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Symptom> retriveAll() throws HibernateException {
		List<Symptom> list = sessionFactory.getCurrentSession().createQuery("from Symptom").list();
		for (Symptom symptom : list) {
			logger.info("Symptom list::" + symptom);
		}
		return sessionFactory.getCurrentSession().createCriteria(Symptom.class).list();
		
	}
	
}
