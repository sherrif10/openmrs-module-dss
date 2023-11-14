package org.openmrs.module.dss.api.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class schedularSymptom {
	
	private Log log = LogFactory.getLog(SymptomETL.class);
	
	private boolean jobRunning = false;
	
	SymptomETL symptomETL = new SymptomETL();
	
	//method to run periodically
	public void scheduleJob() {
		//check if the job is running, if yes, skip the execution
		if (jobRunning) {
			log.warn("Job is already running. Skipping this execution.");
			return;
		}
		try {
			jobRunning = true;
			
			//logic to connect to the database and select data
			symptomETL.connectToDatabaseAndSelectData();
			
			log.info("Scheduled job completed successfully.");
		}
		finally {
			jobRunning = false;
		}
	}
}
