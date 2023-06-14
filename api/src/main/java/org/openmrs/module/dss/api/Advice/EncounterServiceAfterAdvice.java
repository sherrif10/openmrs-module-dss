package org.openmrs.module.dss.api.Advice;

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.EncounterService;
import org.openmrs.api.context.Context;
import org.springframework.aop.AfterReturningAdvice;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;

import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Set;

public class EncounterServiceAfterAdvice implements AfterReturningAdvice {

  private Log log = LogFactory.getLog(this.getClass());
  private EncounterService encounterService = Context.getEncounterService();

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

      if (encounter != null && encounter.getAllObs() != null) {
        if (encounterService != null) {
          Set<Obs> observations = encounter.getObs();
          // Iterate through the observations and add them to the ArrayList
          ArrayList<Concept> observationList = new ArrayList<>();
          for (Obs observation : observations) {
            Concept valueCoded = observation.getValueCoded();
            observationList.add(valueCoded);
            // Convert the observationList to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(observationList);
            Logger.getAnonymousLogger().info("json.............." + json);
          }

            // Convert the observationList to JSON
             ObjectMapper objectMapper = new ObjectMapper();
             String json = objectMapper.writeValueAsString(observationList);
             Logger.getAnonymousLogger().info("json.............." + json);

             HttpClient httpClient = HttpClientBuilder.create().build();

             HttpPost request = new HttpPost("http://13.246.5.98:8000/predict"); // Replace with the actual API endpoint URL

             // Set the JSON request body
             StringEntity requestEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
             request.setEntity(requestEntity);

             try {
               // Execute the request
               HttpResponse response = httpClient.execute(request);

               // Get the response body
               HttpEntity responseEntity = response.getEntity();
               String responseBody = EntityUtils.toString(responseEntity);

               // Process the response
               System.out.println("Response: " + responseBody);
             }
             catch (Exception e) {
               e.printStackTrace();
             }
          }
        }
      }
    }
  }


