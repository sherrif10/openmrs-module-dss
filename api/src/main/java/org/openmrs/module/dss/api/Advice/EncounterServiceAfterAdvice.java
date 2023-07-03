package org.openmrs.module.dss.api.advice;

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

    if (method.getName().equals("saveEncounter") && args[0] != null && returnValue != null) {
      Encounter encounter = (Encounter) returnValue;

      if (encounter != null && encounter.getAllObs() != null && encounterService != null) {

          Set<Obs> observations = encounter.getObs();
          // Iterate through the observations and add them to the ArrayList
          ArrayList<Concept> observationList = new ArrayList<>();
          ArrayList<Integer> resultArray = new ArrayList<>();
          for (Obs observation : observations) {
            Concept valueCoded = observation.getValueCoded();
            observationList.add(valueCoded); 
             String con = valueCoded.toString();
             if (con.contains("Concept #1065")) {
                resultArray.add(1);
              } else if(con.contains("Concept #1066")){
                resultArray.add(0);
              } 
          }
String json = "{\n" +
      "  \"LossOfSmell\": "+resultArray.get(0)+",\n" +
      "  \"Fever\": "+resultArray.get(1)+",\n" +
      "  \"LossOfTaste\": "+resultArray.get(2)+",\n" +
      "  \"Cough\": "+resultArray.get(3)+",\n" +
      "  \"Headache\": "+resultArray.get(4)+",\n" +
      "  \"NoAppetite\": "+resultArray.get(5)+",\n" +
      "  \"Paralysis\": "+resultArray.get(6)+",\n" +
      "  \"contactWithCOVIDPatient\": "+resultArray.get(7)+",\n" +
      "  \"AlteredConsciousness\": "+resultArray.get(8)+",\n" +
      "  \"DiscolorationToesFingers\": "+resultArray.get(9)+",\n" +
      "  \"Severity\": "+resultArray.get(10)+",\n" +
      "  \"Age\": 43,\n" +
      "  \"SoreThroat\": "+resultArray.get(11)+",\n" +
      "  \"RunnyNose\": "+resultArray.get(12)+",\n" +
      "  \"Muscle aches\": "+resultArray.get(13)+",\n" +
      "  \"ShortBreath\": "+resultArray.get(14)+",\n" +
      "  \"Rash\": "+resultArray.get(15)+",\n" +
      "  \"Nausea\": 0,\n" +
      "  \"requireMedicalAtt\": 1,\n" +
      "  \"Vomiting\": 1,\n" +
      "  \"requireToMissSchool\": 1\n" +
    "}";          

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://13.246.5.98:8000/predict");
        // Set the JSON request body
        StringEntity requestEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        request.setEntity(requestEntity);

      try {
          
      // Execute the request
      HttpResponse response = httpClient.execute(request);
      // Get the response body
      
      HttpEntity responseEntity = response.getEntity();
      String responseBody = EntityUtils.toString(responseEntity);

      String numericValue = responseBody.substring(responseBody.indexOf(":") + 1, responseBody.indexOf("}")).trim();
      int intValue = Integer.parseInt(numericValue);      
      //Map the prediction value to the appropriate concept ID
      int predictionValueConceptId = (intValue == 0) ? 1066 : 1065;

      //Create a new Obs object for the prediction value
       String CONCEPT_UUID_FOR_PREDICTION = "prediction";
      //using ternally operator
      String[] CONCEPT_UUIDS_FOR_PREDICTION_VALUE = {"1066", "1065"};

      Obs predictionObs = new Obs();

      predictionObs.setPerson(encounter.getPatient()); // Set the person (patient) associated with the observation
      predictionObs.setEncounter(encounter);
      predictionObs.setValueText(CONCEPT_UUIDS_FOR_PREDICTION_VALUE[intValue]);            
      predictionObs.setCreator(Context.getAuthenticatedUser());
      predictionObs.setConcept(Context.getConceptService().getConcept(CONCEPT_UUID_FOR_PREDICTION)); // Replace with the appropriate concept UUID
      predictionObs.setValueCoded(Context.getConceptService().getConcept(CONCEPT_UUIDS_FOR_PREDICTION_VALUE[intValue])); // Replace with the appropriate concept UUID
      predictionObs.setObsDatetime(encounter.getEncounterDatetime());
      obsService.saveObs(predictionObs, null);

      Logger.getAnonymousLogger().info("******Response*******: " + predictionObs);
      Logger.getAnonymousLogger().info("******Response*******: " + predictionValueConceptId);

      } catch (Exception e) {
          e.printStackTrace();
      } 
    }
  }
  }       
 }

