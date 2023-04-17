package org.openmrs.module.dss.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.module.dss.api.dao.SymptomDao;
import org.openmrs.module.dss.api.impl.SymptomServiceImpl;
import org.openmrs.module.dss.api.model.Symptom;
import org.openmrs.test.BaseModuleContextSensitiveTest;

public class SymptomServiceTest extends BaseModuleContextSensitiveTest {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@InjectMocks
	SymptomServiceImpl symptomServiceImpl;
	
	@Mock
	UserService userService;
	
	Symptom symptom;
	
	@Mock
	SymptomDao dao;
	
	@Before
	public void setUpMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldCreateSymptom() throws Exception {
		symptom = new Symptom();
		symptom.setFever("fever");
		symptom.setJointAches("jointAches");
		symptom.setLossOfSmell("lossOfSmell");
		symptom.setLossOfTaste("lossOfTaste");
		
		when(dao.saveOrUpdate(symptom)).thenReturn(symptom);
		
		User user = new User();
		when(userService.getUser(1)).thenReturn(user);
		symptomServiceImpl.saveOrUpdate(symptom);
		assertEquals("fever", symptom.getFever());
		assertEquals("jointAches", symptom.getJointAches());
		assertEquals("lossOfSmell", symptom.getLossOfSmell());
		assertEquals("lossOfTaste", symptom.getLossOfTaste());
	}
	
	@Test
	public void shouldDeleteSymptomFromDb() {
		symptom = new Symptom();
		symptom.setFever("fever");
		symptom.setJointAches("jointAches");
		symptom.setLossOfSmell("lossOfSmell");
		symptom.setLossOfTaste("lossOfTaste");
		
		when(dao.saveOrUpdate(symptom)).thenReturn(symptom);
		symptomServiceImpl.purgeSymptoms(symptom);
		assertNotNull(symptom);
	}
}
