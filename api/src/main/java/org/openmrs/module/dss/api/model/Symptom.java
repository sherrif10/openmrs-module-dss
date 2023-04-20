package org.openmrs.module.dss.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsMetadata;

@Entity(name = "dss_symptom")
@Table(name = "dss_symptom")
public class Symptom extends BaseOpenmrsMetadata {
	
	@Override
	public String toString() {
		return "Symptom [id=" + id + ", fever=" + fever + ", MuscleAches=" + MuscleAches + ", LossOfSmell=" + LossOfSmell
		        + ", PainFulBreathing=" + PainFulBreathing + ", ShortnessOfBreath=" + ShortnessOfBreath + ", JointAches="
		        + JointAches + ", RunnyNose=" + RunnyNose + ", OtherNueral=" + OtherNueral
		        + ", RelationshipWithContactPerson=" + RelationshipWithContactPerson + ", Diabetes=" + Diabetes
		        + ", SoreThroats=" + SoreThroats + ", LossOfTaste=" + LossOfTaste + ", Occupation=" + Occupation
		        + ", Vomiting=" + Vomiting + ", Nuesea=" + Nuesea + ", Rash=" + Rash + "]";
	}
	
	public Symptom(Integer id, String fever, String muscleAches, String lossOfSmell, String painFulBreathing,
	    String shortnessOfBreath, String jointAches, String runnyNose, String otherNueral,
	    String relationshipWithContactPerson, String diabetes, String soreThroats, String lossOfTaste, String occupation,
	    String vomiting, String nuesea, String rash) {
		this.id = id;
		this.fever = fever;
		MuscleAches = muscleAches;
		LossOfSmell = lossOfSmell;
		PainFulBreathing = painFulBreathing;
		ShortnessOfBreath = shortnessOfBreath;
		JointAches = jointAches;
		RunnyNose = runnyNose;
		OtherNueral = otherNueral;
		RelationshipWithContactPerson = relationshipWithContactPerson;
		Diabetes = diabetes;
		SoreThroats = soreThroats;
		LossOfTaste = lossOfTaste;
		Occupation = occupation;
		Vomiting = vomiting;
		Nuesea = nuesea;
		Rash = rash;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "dss_symptom_id")
	private Integer id;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
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
	
	//our constructor below
	
	public Symptom() {
	}
	
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
