package org.openmrs.module.dss.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;

import org.openmrs.api.context.Context;
import org.openmrs.module.dss.api.model.Symptom;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.MetadataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ObjectNotFoundException;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;

import org.openmrs.module.dss.api.SymptomService;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;

/**
 * {@link Resource} for symptom, supporting standard CRUD operations
 */
@SuppressWarnings("unused")
@Resource(name = RestConstants.VERSION_1 + "/symptom", supportedClass = Symptom.class, supportedOpenmrsVersions = { "1.9.*",
        "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*", "2.3.*", "2.4.*", "2.5.*", "2.6.*" })
public class SymptomResource extends MetadataDelegatingCrudResource<Symptom> {
	
	private SymptomService symptomService;
	
	@Override
	public List<Representation> getAvailableRepresentations() {
		return Arrays.asList(Representation.DEFAULT, Representation.REF);
	}
	
	@Override
	public NeedsPaging<Symptom> doGetAll(RequestContext requestContext) throws ResponseException {
		return new NeedsPaging<Symptom>(new ArrayList<Symptom>(Context.getService(SymptomService.class).retriveAll(null)),
		        requestContext);
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource#getRepresentationDescription(org.openmrs.module.webservices.rest.web.representation.Representation)
	 */
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
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
			
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
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
			description.addSelfLink();
			return description;
		} else if (rep instanceof RefRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("fever");
			description.addSelfLink();
			return description;
		}
		return null;
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#getCreatableProperties()
	 */
	@Override
	public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
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
	
	@Override
	public Model getGETModel(Representation rep) {
		ModelImpl model = (ModelImpl) super.getGETModel(rep);
		if (rep instanceof DefaultRepresentation || rep instanceof FullRepresentation) {
			model.property("uuid", new StringProperty()).property("fever", new StringProperty())
			        .property("MuscleAches", new StringProperty()).property("LossOfSmell", new StringProperty())
			        .property("PainFulBreathing", new StringProperty()).property("ShortnessOfBreath", new StringProperty())
			        .property("JointAches", new StringProperty()).property("RunnyNose", new StringProperty())
			        .property("Occupation", new StringProperty()).property("Vomiting", new StringProperty())
			        .property("Nuesea", new StringProperty()).property("Rash", new StringProperty())
			        .addProperty("attributes", new ArrayProperty(new RefProperty("#/definitions/SymptomAttributeGetRef")));
			
		}
		if (rep instanceof DefaultRepresentation) {
			model.property("fever", new RefProperty("#/definitions/FeverGetRef"))
			        .property("MuscleAches", new RefProperty("#/definitions/MuscleAchesGetRef"))
			        .property("LossOfSmell", new RefProperty("#/definitions/LossOfSmellGetRef"))
			        .property("PainFulBreathing", new RefProperty("#/definitions/PainFulBreathingGetRef"));
			
		} else if (rep instanceof FullRepresentation) {
			model.property("fever", new RefProperty("#/definitions/FeverGetRef"))
			        .property("MuscleAches", new RefProperty("#/definitions/MuscleAchesGetRef"))
			        .property("LossOfSmell", new RefProperty("#/definitions/LossOfSmellGetRef"))
			        .property("PainFulBreathing", new RefProperty("#/definitions/PainFulBreathingGetRef"))
			        .property("ShortnessOfBreath", new RefProperty("#/definitions/ShortnessOfBreathGetRef"))
			        .property("MuscleAches", new RefProperty("#/definitions/MuscleAchesGetRef"))
			        .property("LossOfSmell", new RefProperty("#/definitions/LossOfSmellGetRef"))
			        .property("PainFulBreathing", new RefProperty("#/definitions/PainFulBreathingGetRef"))
			        .property("Nuesea", new RefProperty("#/definitions/NuesaeGetRef"));
			
		}
		return model;
	}
	
	@Override
	public Model getCREATEModel(Representation representation) {
		ModelImpl model = new ModelImpl().property("fever", new ArrayProperty(new RefProperty("#/definitions/FeverCreate")))
		        .property("MuscleAches", new ArrayProperty(new RefProperty("#/definitions/MuscleAchesCreate")))
		        .property("LossOfSmell", new RefProperty("#/definitions/LossOfSmellGetRef"))
		        .property("PainFulBreathing", new RefProperty("#/definitions/PainFulBreathingGetRef"))
		        .property("ShortnessOfBreath", new RefProperty("#/definitions/ShortnessOfBreathGetRef"))
		        .property("MuscleAches", new RefProperty("#/definitions/MuscleAchesGetRef"))
		        .property("Nuesea", new RefProperty("#/definitions/NueseaGetRef"))
		        .property("Rash", new RefProperty("#/definitions/RashGetRef"));
		
		model.setRequired(Arrays.asList("fever", "response"));
		model.setRequired(Arrays.asList("muscleAches", "response"));
		model.setRequired(Arrays.asList("LossOfSmell", "response"));
		model.setRequired(Arrays.asList("PainFulBreathing", "response"));
		model.setRequired(Arrays.asList("ShortnessOfBreath", "response"));
		model.setRequired(Arrays.asList("LossOfSmell", "response"));
		model.setRequired(Arrays.asList("Nuesea", "response"));
		model.setRequired(Arrays.asList("Rash", "response"));
		model.setRequired(Arrays.asList("Vomiting", "response"));
		model.setRequired(Arrays.asList("SoreThroats", "response"));
		model.setRequired(Arrays.asList("fever", "response"));
		model.setRequired(Arrays.asList("Occupation", "response"));
		model.setRequired(Arrays.asList("OtherNueral", "response"));
		
		return model;
	}
	
	public SymptomResource() {
		this.symptomService = Context.getService(SymptomService.class);
	}
	
	@Override
	public Model getUPDATEModel(Representation representation) {
		ModelImpl model = new ModelImpl().property("fever", new ArrayProperty(new RefProperty("#/definitions/FeverCreate")))
		        .property("MuscleAches", new ArrayProperty(new RefProperty("#/definitions/MuscleAchesCreate")))
		        .property("LossOfSmell", new StringProperty()).property("PainFulBreathing", new StringProperty());
		
		model.setRequired(Arrays.asList("fever", "response"));
		model.setRequired(Arrays.asList("muscleAches", "response"));
		model.setRequired(Arrays.asList("LossOfSmell", "response"));
		model.setRequired(Arrays.asList("PainFulBreathing", "response"));
		model.setRequired(Arrays.asList("ShortnessOfBreath", "response"));
		model.setRequired(Arrays.asList("LossOfSmell", "response"));
		model.setRequired(Arrays.asList("Nuesea", "response"));
		model.setRequired(Arrays.asList("Rash", "response"));
		model.setRequired(Arrays.asList("Vomiting", "response"));
		model.setRequired(Arrays.asList("SoreThroats", "response"));
		model.setRequired(Arrays.asList("fever", "response"));
		model.setRequired(Arrays.asList("Occupation", "response"));
		model.setRequired(Arrays.asList("OtherNueral", "response"));
		return model;
	}
	
	@Override
	public Symptom newDelegate() {
		return new Symptom();
	}
	
	public Symptom saveOrUpdate(Symptom symptom) {
		return Context.getService(SymptomService.class).saveOrUpdate(symptom);
	}
	
	@Override
	public void delete(Symptom delegate, String reason, RequestContext context) throws ResponseException {
		if (!this.symptomService.getByUniqueId(delegate.getUuid()).isPresent()) {
			this.symptomService.deleteAll();
			return; //  delete is idempotent, so we return success here
		}
		Context.getService(SymptomService.class).deleteAll();
	}
	
	@Override
	public void purge(Symptom delegate, RequestContext context) throws ResponseException {
		this.symptomService.purgeSymptoms(delegate);
	}
	
	@Override
	public Symptom save(Symptom symptom) {
		return Context.getService(SymptomService.class).saveOrUpdate(symptom);
	}
	
	@Override
	public Symptom getByUniqueId(@NotNull String uuid) {
		Optional<Symptom> optionalSymptom = symptomService.getByUniqueId(uuid);
		if (!optionalSymptom.isPresent()) {
			throw new ObjectNotFoundException();
		}
		return optionalSymptom.get();
	}
	
	@PropertyGetter("display")
	public String getDisplay(Symptom symptom) {
		return symptom.getName();
	}
	
	@Override
	public String getResourceVersion() {
		return "2.3";
	}
	
}
