package org.openmrs.module.dss.api.Advice;

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.api.EncounterService;
import org.springframework.aop.AfterReturningAdvice;
import java.util.logging.Logger;

public class EncounterServiceAfterAdvice implements AfterReturningAdvice {
    
    private Log log = LogFactory.getLog(this.getClass());
    private EncounterService encounterService;
    
       @Override
       public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
           Logger.getAnonymousLogger().info("======== in After Advice " + method.getName() + "========");
           
           if (method.getName().equals("saveEncounter") && args[0] != null && returnValue != null) {
               Encounter encounter = (Encounter) returnValue;
               if (encounter != null && encounter.getObs() != null) {
                   encounterService.saveEncounter(encounter);
                   Logger.getAnonymousLogger().info("Encounter details is not null");
                   }
                   Logger.getAnonymousLogger().info("Encounter details is null");

                   Logger.getAnonymousLogger().info("Encounter details: " + encounter.toString());
                     // Log all details of the saved Encounter
                        log.debug("Saved Encounter Details:");
                        log.debug("Encounter ID: " + encounter.getId());
                        log.debug("Encounter Date: " + encounter.getEncounterDatetime());
                        log.debug("Encounter Location: " + encounter.getLocation());
                        // Add any additional details you want to log
           }
             
       }
}


