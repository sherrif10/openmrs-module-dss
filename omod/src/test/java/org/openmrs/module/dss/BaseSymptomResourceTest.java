package org.openmrs.module.dss;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Before;
import org.openmrs.OpenmrsObject;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RestUtil;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceHandler;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@PrepareForTest({ Context.class, RestUtil.class })
public class BaseSymptomResourceTest<Q extends OpenmrsObject, O extends DelegatingResourceHandler<Q>> {
	
	private O resource;
	
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.MODULE)
	private Q object;
	
	@Before
	public void prepareMocks() {
		PowerMockito.mockStatic(RestUtil.class);
		PowerMockito.mockStatic(Context.class);
		
		//By pass authentication
		when(Context.isAuthenticated()).thenReturn(true);
	}
	
	public void verifyDefaultRepresentation(String... properties) {
		DelegatingResourceDescription defaultResourceDescription = resource
		        .getRepresentationDescription(new DefaultRepresentation());
		
		assertThat(defaultResourceDescription, notNullValue());
		for (String prop : properties) {
			assertThat(defaultResourceDescription.getProperties(), hasKey(prop));
		}
	}
	
	public void verifyFullRepresentation(String... properties) {
		DelegatingResourceDescription fullResourceDescription = resource
		        .getRepresentationDescription(new FullRepresentation());
		
		assertThat(fullResourceDescription, notNullValue());
		for (String prop : properties) {
			assertThat(fullResourceDescription.getProperties(), hasKey(prop));
		}
	}
	
	public void verifyCreatableProperties(String... properties) {
		DelegatingResourceDescription creatableProperties = resource.getCreatableProperties();
		
		assertThat(creatableProperties, notNullValue());
		assertThat(creatableProperties.getProperties().keySet(), contains(properties));
	}
	
	public void verifyUpdatableProperties(String... properties) {
		DelegatingResourceDescription updatableProperties = resource.getUpdatableProperties();
		
		assertThat(updatableProperties, notNullValue());
		assertThat(updatableProperties.getProperties().keySet(), contains(properties));
	}
	
}
