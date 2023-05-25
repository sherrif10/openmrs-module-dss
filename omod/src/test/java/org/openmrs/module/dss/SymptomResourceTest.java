// package org.openmrs.module.dss;

// import static org.junit.Assert.assertThat;
// import static org.mockito.Mockito.when;

// import static org.hamcrest.Matchers.notNullValue;
// import static org.hamcrest.Matchers.nullValue;
// import static org.hamcrest.Matchers.is;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.Mock;
// import org.openmrs.api.context.Context;
// import org.openmrs.module.dss.api.SymptomService;
// import org.openmrs.module.dss.api.model.Symptom;
// import org.openmrs.module.dss.resource.SymptomResource;
// import org.openmrs.module.webservices.rest.web.representation.CustomRepresentation;
// import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
// import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
// import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
// import org.powermock.core.classloader.annotations.PowerMockIgnore;
// import org.powermock.modules.junit4.PowerMockRunner;

// @RunWith(PowerMockRunner.class)
// @PowerMockIgnore("jdk.internal.reflect.*")
// public class SymptomResourceTest extends BaseSymptomResourceTest<Symptom, SymptomResource> {

// 	private static final String SYMPTOM_UUID = "6hje567a-fca0-11e5-9e59-08002719a7";

// 	@Mock
// 	private SymptomService service;

// 	private Symptom symptom;

// 	@Before
// 	public void before() throws Exception {
// 		symptom = new Symptom();
// 		symptom.setUuid(SYMPTOM_UUID);
// 		this.prepareMocks();
// 		when(Context.getService(SymptomService.class)).thenReturn(service);

// 		this.setResource(new SymptomResource());
// 		this.setObject(symptom);
// 	}

// 	@Test
// 	public void shouldGetSymptomService() {
// 		assertThat(service, notNullValue());
// 	}

// 	@Test
// 	public void shouldReturnDefaultRepresentation() {
// 		verifyDefaultRepresentation("uuid", "MuscleAches", "PainFulBreathing", "JointAches", "Occupation", "Nuesea");
// 	}

// 	@Test
// 	public void shouldReturnNullForCustomRepresentation() {
// 		CustomRepresentation customRepresentation = new CustomRepresentation("custom-representation");
// 		assertThat(getResource().getRepresentationDescription(customRepresentation), is(nullValue()));
// 	}

// 	@Test
// 	public void shouldNOTReturnNullForDefaultRepresentation() {
// 		assertThat(getResource().getRepresentationDescription(new DefaultRepresentation()), is(notNullValue()));
// 	}

// 	@Test
// 	public void shouldNOTReturnNullForFullRepresentation() {
// 		assertThat(getResource().getRepresentationDescription(new FullRepresentation()), is(notNullValue()));
// 	}

// 	@Test
// 	public void shouldNotReturnNullForRefRepresentation() {
// 		assertThat(getResource().getRepresentationDescription(new RefRepresentation()), is(notNullValue()));
// 	}

// 	@Test
// 	public void shouldInstantiateNewDelegate() {
// 		assertThat(getResource().newDelegate(), notNullValue());
// 	}

// 	@Test
// 	public void verifyResourceVersion() {
// 		assertThat(getResource().getResourceVersion(), is("2.3"));
// 	}
// }
