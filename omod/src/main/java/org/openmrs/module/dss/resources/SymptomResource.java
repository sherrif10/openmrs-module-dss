package org.openmrs.module.dss.resources;

import java.util.Arrays;
import java.util.List;
import org.openmrs.api.context.Context;
import org.openmrs.module.dss.api.model.Symptom;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.MetadataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;

/**
 * {@link Resource} for symptom, supporting standard CRUD operations
 */
@Resource(name = RestConstants.VERSION_1 + "/symptom", supportedClass = Symptom.class, supportedOpenmrsVersions = { "1.8.*",
        "2.0.*", "2.1.*", "2.2.*", "2.3.*", "2.4.* " })
public class SymptomResource extends MetadataDelegatingCrudResource<Symptom> {
	
	@Override
	public List<Representation> getAvailableRepresentations() {
		return Arrays.asList(Representation.DEFAULT, Representation.REF);
	}
	
	@Override
	public NeedsPaging<Symptom> doGetAll(RequestContext context) {
		return new NeedsPaging<Symptom>(Context.getService(SymptomService.class).getAllSymptoms(), context);
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource#getRepresentationDescription(org.openmrs.module.webservices.rest.web.representation.Representation)
	 */
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		DelegatingResourceDescription description = null;
		
		if (rep instanceof DefaultRepresentation) {
			description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("fever");
			description.addProperty("MuscleAches");
			description.addProperty("LossOfSmell");
			description.addProperty("PainFulBreathing");
			description.addProperty("ShortnessOfBreath");
			description.addProperty("JointAches");
			description.addProperty("RunnyNose");
			description.addProperty("OtherNueral");
			description.addProperty("SoreThroats");
			description.addProperty("LossOfTaste");
			description.addProperty("Occupation");
			description.addProperty("Vomiting");
			description.addProperty("Nuesea");
			description.addProperty("Rash");
			description.addProperty("symptom", Representation.DEFAULT);
			description.addSelfLink();
			
		} else if (rep instanceof FullRepresentation) {
			description = new DelegatingResourceDescription();
			description.addProperty("fever");
			description.addProperty("MuscleAches");
			description.addProperty("LossOfSmell");
			description.addProperty("PainFulBreathing");
			description.addProperty("ShortnessOfBreath");
			description.addProperty("JointAches");
			description.addProperty("RunnyNose");
			description.addProperty("OtherNueral");
			description.addProperty("SoreThroats");
			description.addProperty("LossOfTaste");
			description.addProperty("Occupation");
			description.addProperty("Vomiting");
			description.addProperty("Nuesea");
			description.addProperty("Rash");
			description.addSelfLink();
			return description;
		} else if (rep instanceof RefRepresentation) {
			description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("MuscleAches");
			description.addProperty("LossOfSmell");
			description.addProperty("PainFulBreathing");
			description.addProperty("ShortnessOfBreath");
			description.addProperty("JointAches");
			description.addProperty("RunnyNose");
			description.addProperty("OtherNueral");
			description.addProperty("SoreThroats");
			description.addProperty("LossOfTaste");
			description.addProperty("Occupation");
			description.addProperty("Vomiting");
			description.addProperty("Nuesea");
			description.addProperty("Rash");
			description.addSelfLink();
		}
		return description;
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#getCreatableProperties()
	 */
	@Override
	public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("fever");
		description.addProperty("MuscleAches");
		description.addProperty("LossOfSmell");
		description.addProperty("PainFulBreathing");
		description.addProperty("ShortnessOfBreath");
		description.addProperty("JointAches");
		description.addProperty("RunnyNose");
		description.addProperty("OtherNueral");
		description.addProperty("SoreThroats");
		description.addProperty("LossOfTaste");
		description.addProperty("Occupation");
		description.addProperty("Vomiting");
		description.addProperty("Nuesea");
		description.addProperty("Rash");
		return description;
	}
	
	/**
	 * @throws org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#getUpdatableProperties()
	 */
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("uuid");
		description.addProperty("fever");
		description.addProperty("MuscleAches");
		description.addProperty("LossOfSmell");
		description.addProperty("PainFulBreathing");
		description.addProperty("ShortnessOfBreath");
		description.addProperty("JointAches");
		description.addProperty("RunnyNose");
		description.addProperty("OtherNueral");
		description.addProperty("SoreThroats");
		description.addProperty("LossOfTaste");
		description.addProperty("Occupation");
		description.addProperty("Vomiting");
		description.addProperty("Nuesea");
		description.addProperty("Rash");
		return description;
	}
	
	public SymptomResource() {
		Context.getService(SymptomService.class);
	}
	
	@Override
	public Symptom newDelegate() {
		return new Symptom();
	}
	
	public Symptom saveOrUpdate(Symptom symptom) throws Exception {
		Context.getService(SymptomService.class).saveOrUpdate(symptom);
		return Context.getService(SymptomService.class).getSymptomById(symptom.getId());
	}
	
	@Override
	public void delete(Symptom delegate, String reason, RequestContext context) throws ResponseException {
		Context.getService(SymptomService.class).purgeSymptoms(delegate);
	}
	
	@Override
	public void purge(Symptom symptom, RequestContext context) throws ResponseException {
		if (symptom != null) {
			Context.getService(SymptomService.class).purgeSymptoms(symptom);
		}
	}
	
	public Symptom save(Symptom symptom) {
		Context.getService(SymptomResource.class).save(symptom);
		return Context.getService(SymptomService.class).getSymptomById(symptom.getId());
	}
	
	@Override
	public Symptom getByUniqueId(String uniqueId) {
		Symptom symptom = Context.getService(SymptomService.class).getSymptomByUuid(uniqueId);
		if (symptom == null) {
			symptom = Context.getService(SymptomService.class).getSymptomByUuid(uniqueId);
		}
		return symptom;
	}
	
	public List<Representation> getAvailablRepresentations() {
		return Arrays.asList(Representation.DEFAULT, Representation.FULL);
	}
	
	@Override
	public String getResourceVersion() {
		//What determines the resource version? is it the target platform version or just 1.8
		return "2.3";
	}
}
