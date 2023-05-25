package org.openmrs.module.dss.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;

@Entity(name = "dss_symptom")
@Table(name = "dss_symptom")
public class Symptom extends BaseOpenmrsData {
	
	private static final long serialVersionUID = 1L;
	
	public Symptom() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dss_symptom_id")
	private Integer Id;
	
	@Override
	public String toString() {
		return "Symptom [Id=" + Id + ", fever=" + fever + ", MuscleAches=" + MuscleAches + ", LossOfSmell=" + LossOfSmell
		        + ", PainFulBreathing=" + PainFulBreathing + ", ShortnessOfBreath=" + ShortnessOfBreath + ", JointAches="
		        + JointAches + ", RunnyNose=" + RunnyNose + ", OtherNueral=" + OtherNueral
		        + ", RelationshipWithContactPerson=" + RelationshipWithContactPerson + ", Diabetes=" + Diabetes
		        + ", SoreThroats=" + SoreThroats + ", LossOfTaste=" + LossOfTaste + ", Occupation=" + Occupation
		        + ", Vomiting=" + Vomiting + ", Nuesea=" + Nuesea + ", Rash=" + Rash + "]";
	}
	
	@Override
	public Integer getId() {
		return Id;
	}
	
	public Symptom(String fever, String MuscleAches, String LossOfSmell, String LossOfTaste, String painFulBreathing,
	    String ShortnessOfBreath, String jointAches, String OtherNueral, String RunnyNose,
	    String RelationshipWithContactPerson, String Diabetes, String SoreThroats, String Occupation, String Rash,
	    String Vomiting, String Nuesea) {
		setFever(fever);
		setMuscleAches(MuscleAches);
		setLossOfSmell(LossOfSmell);
		setLossOfTaste(LossOfTaste);
		setPainFulBreathing(painFulBreathing);
		setJointAches(jointAches);
		setOtherNueral(OtherNueral);
		setOtherNueral(OtherNueral);
		setRunnyNose(RunnyNose);
		setRelationshipWithContactPerson(RelationshipWithContactPerson);
		setDiabetes(Diabetes);
		setSoreThroats(SoreThroats);
		setOccupation(Occupation);
		setRash(Rash);
		setVomiting(Vomiting);
		setNuesea(Nuesea);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Symptom) {
			Symptom sys = (Symptom) obj;
			if (getId() != null && sys.getId() != null)
				return getId().equals(sys.getId());
		}
		// if symptom id is null for either object, for equality the two objects must be the same
		return this == obj;
	}
	
	public int hashcode() {
		if (getId() == null)
			return super.hashCode();
		return getId().hashCode();
	}
	
	@Override
	public void setId(Integer id) {
		this.Id = id;
	}
	
	@Column(name = "fever")
	public String fever;
	
	@Column(name = "muscleAches")
	public String MuscleAches;
	
	@Column(name = "lossOfSmell")
	public String LossOfSmell;
	
	@Column(name = "painFulBreathing")
	public String PainFulBreathing;
	
	@Column(name = "shortnessOfBreath")
	public String ShortnessOfBreath;
	
	@Column(name = "jointAches")
	public String JointAches;
	
	@Column(name = "runnyNose")
	public String RunnyNose;
	
	@Column(name = "otherNueral")
	public String OtherNueral;
	
	@Column(name = "relationshipWithContactPerson")
	public String RelationshipWithContactPerson;
	
	@Column(name = "diabetes")
	public String Diabetes;
	
	@Column(name = "soreThroats")
	public String SoreThroats;
	
	@Column(name = "lossOfTaste")
	public String LossOfTaste;
	
	@Column(name = "occupation")
	public String Occupation;
	
	@Column(name = "vomiting")
	public String Vomiting;
	
	@Column(name = "nuesea")
	public String Nuesea;
	
	@Column(name = "rash")
	public String Rash;
	
	public String getFever() {
		return fever;
	}
	
	public void setFever(String fever) {
		this.fever = fever;
	}
	
	public String getMuscleAches() {
		return MuscleAches;
	}
	
	public void setMuscleAches(String muscleAches) {
		MuscleAches = muscleAches;
	}
	
	public String getLossOfSmell() {
		return LossOfSmell;
	}
	
	public void setLossOfSmell(String lossOfSmell) {
		LossOfSmell = lossOfSmell;
	}
	
	public String getPainFulBreathing() {
		return PainFulBreathing;
	}
	
	public void setPainFulBreathing(String painFulBreathing) {
		PainFulBreathing = painFulBreathing;
	}
	
	public String getShortnessOfBreath() {
		return ShortnessOfBreath;
	}
	
	public void setShortnessOfBreath(String shortnessOfBreath) {
		ShortnessOfBreath = shortnessOfBreath;
	}
	
	public String getJointAches() {
		return JointAches;
	}
	
	public void setJointAches(String jointAches) {
		JointAches = jointAches;
	}
	
	public String getRunnyNose() {
		return RunnyNose;
	}
	
	public void setRunnyNose(String runnyNose) {
		RunnyNose = runnyNose;
	}
	
	public String getOtherNueral() {
		return OtherNueral;
	}
	
	public void setOtherNueral(String otherNueral) {
		OtherNueral = otherNueral;
	}
	
	public String getRelationshipWithContactPerson() {
		return RelationshipWithContactPerson;
	}
	
	public void setRelationshipWithContactPerson(String relationshipWithContactPerson) {
		RelationshipWithContactPerson = relationshipWithContactPerson;
	}
	
	public String getDiabetes() {
		return Diabetes;
	}
	
	public void setDiabetes(String diabetes) {
		Diabetes = diabetes;
	}
	
	public String getSoreThroats() {
		return SoreThroats;
	}
	
	public void setSoreThroats(String soreThroats) {
		SoreThroats = soreThroats;
	}
	
	public String getLossOfTaste() {
		return LossOfTaste;
	}
	
	public void setLossOfTaste(String lossOfTaste) {
		LossOfTaste = lossOfTaste;
	}
	
	public String getOccupation() {
		return Occupation;
	}
	
	public void setOccupation(String occupation) {
		Occupation = occupation;
	}
	
	public String getVomiting() {
		return Vomiting;
	}
	
	public void setVomiting(String vomiting) {
		Vomiting = vomiting;
	}
	
	public String getNuesea() {
		return Nuesea;
	}
	
	public void setNuesea(String nuesea) {
		Nuesea = nuesea;
	}
	
	public String getRash() {
		return Rash;
	}
	
	public void setRash(String rash) {
		Rash = rash;
	}
	
}
