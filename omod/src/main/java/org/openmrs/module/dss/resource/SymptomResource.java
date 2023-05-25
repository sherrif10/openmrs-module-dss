package org.openmrs.module.dss.resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.dss.api.model.Symptom;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;

/**
 * {@link Resource} for symptom, supporting standard CRUD operations
 */
@Resource(name = RestConstants.VERSION_1 + "/symptom", supportedClass = Symptom.class, supportedOpenmrsVersions = { "1.8.*",
        "1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*", "2.3.*", "2.4.*", "2.5.*", "2.6.*" })
public class SymptomResource extends DataDelegatingCrudResource<Symptom> {
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		DelegatingResourceDescription description = null;
		
		if (rep instanceof DefaultRepresentation || rep instanceof FullRepresentation) {
			description = new DelegatingResourceDescription();
			description.addProperty("fever");
			description.addProperty("muscleAches");
			description.addProperty("lossOfSmell");
			description.addProperty("lossOfTaste");
			description.addProperty("painFulBreathing");
			description.addProperty("shortnessOfBreathin");
			description.addProperty("jointAches");
			description.addProperty("runnyNose");
			description.addProperty("otherNueral");
			description.addProperty("shortnessOfBreath");
			description.addProperty("soreThroat");
			description.addProperty("occupation");
			description.addProperty("vomiting");
			description.addProperty("nuesea");
			description.addProperty("rash");
			
			if (rep instanceof DefaultRepresentation) {
				description.addSelfLink();
				description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			} else if (rep instanceof FullRepresentation) {
				description.addProperty("auditInfo");
				description.addSelfLink();
				return description;
			}
		}
		return description;
	}
	
	public Symptom newDelegate() {
		return new Symptom();
	}
	
	@Override
	public Symptom save(Symptom symptom) {
		try {
			Context.getService(SymptomService.class).saveOrUpdate(symptom);
		}
		catch (Exception e) {
			logger.info(e);
		}
		return symptom;
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() {
		DelegatingResourceDescription cp = super.getCreatableProperties();
		cp.addRequiredProperty("fever");
		cp.addRequiredProperty("muscleAches");
		cp.addRequiredProperty("lossOfSmell");
		cp.addRequiredProperty("painFulBreathin");
		cp.addProperty("shortnessOfBreathing");
		cp.addProperty("jointAches");
		cp.addProperty("runnyNose");
		cp.addProperty("otherNueral");
		cp.addProperty("soreThroat");
		cp.addProperty("lossOfTaste");
		cp.addProperty("occupation");
		cp.addProperty("vomiting");
		cp.addProperty("nuesea");
		cp.addProperty("rash");
		
		return cp;
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() {
		DelegatingResourceDescription cp = super.getUpdatableProperties();
		cp.addRequiredProperty("fever");
		cp.addRequiredProperty("muscleAches");
		cp.addRequiredProperty("lossOfSmell");
		cp.addRequiredProperty("painFulBreathin");
		cp.addProperty("shortnessOfBreathing");
		cp.addProperty("jointAches");
		cp.addProperty("runnyNose");
		cp.addProperty("otherNueral");
		cp.addProperty("soreThroat");
		cp.addProperty("lossOfTaste");
		cp.addProperty("occupation");
		cp.addProperty("vomiting");
		cp.addProperty("nuesea");
		cp.addProperty("rash");
		
		return cp;
	}
	
	@Override
	public Symptom getByUniqueId(String symptomId) {
		Symptom symptom = Context.getService(SymptomService.class).getSymptomByUuid(symptomId);
		if (symptom == null) {
			symptom = Context.getService(SymptomService.class).getSymptomByUuid(symptomId);
		}
		return symptom;
	}
	
	@Override
	public void purge(Symptom symptom, RequestContext request) throws ResponseException {
		Context.getService(SymptomService.class).purgeSymptoms(symptom);
	}
	
	@Override
	protected PageableResult doGetAll(RequestContext context) throws ResponseException {
		return new NeedsPaging<Symptom>(Context.getService(SymptomService.class).getAllSymptoms(), context);
	}
	
	public static String getStringFilter(String param, RequestContext req) {
		return (StringUtils.isNotBlank(req.getParameter(param))) ? req.getParameter(param) : null;
	}
	
	public static Boolean getBooleanFilter(String param, RequestContext req) {
		String strval = getStringFilter(param, req);
		return strval == null ? null : Boolean.parseBoolean(strval);
	}
	
	@Override
	protected void delete(Symptom delegate, String reason, RequestContext context) throws ResponseException {
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
}
