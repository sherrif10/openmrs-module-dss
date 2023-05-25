package org.openmrs.module.dss.api.impl;

import java.util.Comparator;

import org.openmrs.module.dss.api.model.Symptom;

public class TagAlphaComparator implements Comparator<Symptom> {
	
	public int compare(Symptom o1, Symptom o2) {
		return o1.getFever().compareTo(o2.getFever());
	}
}
