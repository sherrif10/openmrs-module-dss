/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 * <p/>
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 * <p/>
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.dss.api;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.descriptor.EncounterTypeDescriptor;

public class DssMetadataBundle extends AbstractMetadataBundle {
	
	@Override
	public void install() throws Exception {
		install(SYMPTOM_ENCOUNTER_TYPE);
	}
	
	public static EncounterTypeDescriptor SYMPTOM_ENCOUNTER_TYPE = new EncounterTypeDescriptor() {
		
		@Override
		public String uuid() {
			return "1ecd35a2-edaa-11ed-a05b-0242ac120003";
		}
		
		@Override
		public String name() {
			return "Symptom Form";
		}
		
		@Override
		public String description() {
			return "An encounter when a patient is positive for syphilis to track partners";
		}
		
	};
}
