package org.openmrs.module.dss.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsMetadata;

@Entity
@Table(name = "dss_symptom")
public class Symptom extends BaseOpenmrsMetadata {
	
	private static final long serialVersionUID = 1L;
	
	public Symptom() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "dss_symptom_id")
	private Integer symptomId;
	
	@Override
	public Integer getId() {
		return symptomId;
	}
	
	@Override
	public void setId(Integer id) {
		this.symptomId = id;
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
