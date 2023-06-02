package org.openmrs.module.dss.api.Advice;

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.api.EncounterService;
import org.openmrs.api.context.Context;
//import org.openmrs.Obs;
//import org.openmrs.api.EncounterService;
//import org.openmrs.api.impl.EncounterServiceImpl;
import org.springframework.aop.AfterReturningAdvice;

import java.util.logging.Logger;

public class EncounterServiceAfterAdvice implements AfterReturningAdvice {
    
  private Log log = LogFactory.getLog(this.getClass());
  private EncounterService encounterService = Context.getEncounterService() ;

    /*
 * (non-Javadoc) * @see
 * org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object,
 * java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
 * 
 * depends on org.openmrs.api.impl.EncounterServiceImpl
 */

       @Override
       public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        Logger.getAnonymousLogger().info("======== in After Advice " + method.getName() + "========");

        if (method.getName().equals("saveEncounter") && args[0] != null && returnValue != null) {
          Encounter encounter = (Encounter) returnValue;
            if (encounter != null && encounter.getObs() != null) {
              if (encounterService != null) {
            
               //encounterService.saveEncounter(encounter);
                Logger.getAnonymousLogger().info("we are able to save encounter");
            
              } else {
                Logger.getAnonymousLogger().info("Encounter service is null");
              }
            
                log.debug(".........Saved Encounter Details:.................");
                log.debug("Encounter ID: " + encounter.getId());
                log.debug("Encounter Date: " + encounter.getEncounterDatetime());
                log.debug("Encounter Location: " + encounter.getLocation());

            } else {
                Logger.getAnonymousLogger().info("Encounter details is null");
            }
        } else if (method.getName().equalsIgnoreCase("unvoidEncounter")) {
            if (returnValue != null) {
              Logger.getAnonymousLogger().info("......un voided encounter..........");
              }
                
        }
    }
  }
  
  
       



