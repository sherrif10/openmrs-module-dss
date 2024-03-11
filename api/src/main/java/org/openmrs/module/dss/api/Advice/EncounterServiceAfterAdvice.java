package org.openmrs.module.dss.api.Advice;

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.EncounterService;
import org.openmrs.api.ObsService;
import org.openmrs.api.context.Context;
import org.springframework.aop.AfterReturningAdvice;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.ArrayList;
import java.util.Set;

public class EncounterServiceAfterAdvice implements AfterReturningAdvice {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	private EncounterService encounterService = Context.getEncounterService();
	
	private ObsService obsService = Context.getObsService();
	
	/*
	* (non-Javadoc) * @see


	* org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object,
	* java.lang.reflect.Method, java.lang.Object[], java.lang.Object) 
	* depends on org.openmrs.api.impl.EncounterServiceImpl
	*/
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		Logger.getAnonymousLogger().info("******Entering into the afterReturning method*******");
		if (method.getName().equals("saveEncounter") && args[0] != null && returnValue != null) {
			Encounter encounter = (Encounter) returnValue;
			
			if (encounter != null) {
				if (encounter.getAllObs() != null) {
					if (encounterService != null) {
						Set<Obs> observations = encounter.getObs();
						ArrayList<Concept> observationList = new ArrayList<Concept>();
						ArrayList<Integer> resultArray = new ArrayList<Integer>();
						for (Obs observation : observations) {
							Concept valueCoded = observation.getValueCoded();
							observationList.add(valueCoded);
							String con = valueCoded.toString();
							if (con.contains("Concept #1065")) {
								resultArray.add(1);
							} else if (con.contains("Concept #1066")) {
								resultArray.add(0);
							}
						}
			
						if (resultArray.size() >= 9) {
							int severityvalue = severityValue(resultArray.get(0), resultArray.get(1), resultArray.get(2),
									resultArray.get(3), resultArray.get(4), resultArray.get(5), resultArray.get(6), resultArray.get(7),
									resultArray.get(8));
			
							String json = "{\n" + "  \"LossOfSmell\": " + resultArray.get(0) + ",\n" + "  \"Fever\": "
									+ resultArray.get(1) + ",\n" + "  \"LossOfTaste\": " + resultArray.get(2) + ",\n" + "  \"Cough\": "
									+ resultArray.get(3) + ",\n" + "  \"Headache\": " + resultArray.get(4) + ",\n"
									+ "  \"NoAppetite\": " + resultArray.get(5) + ",\n" + "  \"Paralysis\": " + resultArray.get(6)
									+ ",\n" + "  \"contactWithCOVIDPatient\": " + resultArray.get(7) + ",\n"
									+ "  \"AlteredConsciousness\": " + resultArray.get(8) + ",\n" + "  \"DiscolorationToesFingers\": "
									+ resultArray.get(9) + ",\n" + "  \"Severity\": " + severityvalue + ",\n" + "  \"Age\": 43,\n"
									+ "  \"SoreThroat\": " + resultArray.get(11) + ",\n" + "  \"RunnyNose\": " + resultArray.get(12)
									+ ",\n" + "  \"Muscle aches\": " + resultArray.get(13) + ",\n" + "  \"ShortBreath\": "
									+ resultArray.get(14) + ",\n" + "  \"Rash\": " + resultArray.get(15) + ",\n" + "  \"Nausea\": 0,\n"
									+ "  \"requireMedicalAtt\": 1,\n" + "  \"Vomiting\": 1,\n" + "  \"requireToMissSchool\": 1\n" + "}";
			
							HttpClient httpClient = HttpClientBuilder.create().build();
							HttpPost request = new HttpPost("http://13.246.5.98:8000/predict");
							StringEntity requestEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
							request.setEntity(requestEntity);
			
							try {
								HttpResponse response = httpClient.execute(request);
								Logger.getAnonymousLogger().info("******HTTP Request Executed*******");
								HttpEntity responseEntity = response.getEntity();
								Logger.getAnonymousLogger().info("******Got Response Entity*******");
								String responseBody = EntityUtils.toString(responseEntity);
								Logger.getAnonymousLogger().info("******Got Response Body*******");
								String predictionValuestr = responseBody.substring(responseBody.indexOf(":") + 1,
										responseBody.indexOf("}")).trim();
								Logger.getAnonymousLogger().info(
										"******Extracted prediction Value string *******: " + predictionValuestr);
								int predictionValueIntr = Integer.parseInt(predictionValuestr);
								Logger.getAnonymousLogger().info(
										"******Parsed a prediction  Value integer*******: " + predictionValueIntr);
								int predictionValueConceptId = (predictionValueIntr == 0) ? 1066 : 1065;
								Logger.getAnonymousLogger().info(
										"******Mapped response from ai server  to Concept ID*******: " + predictionValueConceptId);
								String CONCEPT_UUID_FOR_PREDICTION = "prediction";
								Logger.getAnonymousLogger()
										.info("******Initialized Concept UUID*******: " + CONCEPT_UUID_FOR_PREDICTION);
								String[] CONCEPT_UUIDS_FOR_PREDICTION_VALUE = { "1066", "1065" };
								Logger.getAnonymousLogger().info("******Initialized Concept UUIDs for Prediction Value*******");
								Obs predictionObs = new Obs();
								Logger.getAnonymousLogger().info("******Initialized Prediction Obs Object*******");
								predictionObs.setPerson(encounter.getPatient());
								Logger.getAnonymousLogger().info("******Set Person for Prediction Obs*******" + encounter.getPatient());
								predictionObs.setEncounter(encounter);
								Logger.getAnonymousLogger().info("******Set Encounter for Prediction Obs*******" + encounter);
								predictionObs.setValueText(CONCEPT_UUIDS_FOR_PREDICTION_VALUE[predictionValueIntr]);
								Logger.getAnonymousLogger().info("******Set Value Text for Prediction Obs*******");
								predictionObs.setCreator(Context.getAuthenticatedUser());
								Logger.getAnonymousLogger().info(
										"******Set Creator for Prediction Obs*******" + Context.getAuthenticatedUser());
								predictionObs.setConcept(Context.getConceptService().getConcept(CONCEPT_UUID_FOR_PREDICTION));
								Logger.getAnonymousLogger().info(
										"******Set Concept for Prediction Obs*******"
												+ Context.getConceptService().getConcept(CONCEPT_UUID_FOR_PREDICTION));
								predictionObs.setValueCoded(Context.getConceptService().getConcept(
										CONCEPT_UUIDS_FOR_PREDICTION_VALUE[predictionValueIntr]));
								Logger.getAnonymousLogger().info(
										"******Set Value Coded for Prediction Obs*******"
												+ Context.getConceptService().getConcept(
												CONCEPT_UUIDS_FOR_PREDICTION_VALUE[predictionValueIntr]));
								predictionObs.setObsDatetime(encounter.getEncounterDatetime());
								Logger.getAnonymousLogger().info(
										"******Set Observation Date Time for Prediction Obs*******" + encounter.getEncounterDatetime());
								Logger.getAnonymousLogger().info("******Saving Prediction Obs*******");
								obsService.saveObs(predictionObs, "prediction saved successfully");
								Logger.getAnonymousLogger().info("******Saved Prediction Obs*******");
								Logger.getAnonymousLogger().info("******Final Prediction Obs*******: " + predictionObs);
								Logger.getAnonymousLogger().info(
										"******Final Prediction Value Concept ID*******: " + predictionValueConceptId);
							} catch (Exception e) {
								Logger.getAnonymousLogger().info("****** Exception thrown in after returning method *******");
								e.printStackTrace();
							}
						} else {
							Logger.getAnonymousLogger().info("******Not enough resultArray elements for severity calculation*******");
						}
					} else {
						Logger.getAnonymousLogger().info("******encounterService is null*******");
					}
				} else {
					Logger.getAnonymousLogger().info("******encounter.getAllObs() is null*******");
				}
			} else {
				Logger.getAnonymousLogger().info("******encounter is null*******");
			}
			Logger.getAnonymousLogger().info("******Exiting  afterReturning method*******");
		}
	}
	
	public int severityValue(int diabetes, int hypertension, int pulmonary, int cancer, int heartDisease, int ulcers,
	        int asthma, int goitre, int arthritis) {
		int sum = diabetes + hypertension + pulmonary + cancer + heartDisease + ulcers + asthma + goitre + arthritis;
		int severity;
		
		switch (sum) {
			case 0:
				severity = 0;
				break;
			case 1:
				severity = 1;
				break;
			case 2:
				severity = 2;
				break;
			case 3:
				severity = 3;
				break;
			case 4:
				severity = 4;
				break;
			case 5:
				severity = 5;
				break;
			case 6:
				severity = 6;
				break;
			case 7:
				severity = 7;
				break;
			case 8:
				severity = 8;
				break;
			default:
				severity = 9;
				break;
		}
		return severity;
	}
}
