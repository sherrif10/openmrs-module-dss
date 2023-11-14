package org.openmrs.module.dss.api.advice;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.openmrs.Encounter;
import org.openmrs.EncounterType;
import org.openmrs.Location;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.LocationService;
import org.openmrs.api.ObsService;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.sql.Connection;

public class SymptomETL {
	
	private Log log = LogFactory.getLog(SymptomETL.class);
	
	private static final String JDBC_URL = "jdbc:sqlserver://196.43.147.254:1433;databaseName=icea-views";
	
	private static final String JDBC_USER = "tama";
	
	private static final String JDBC_PASSWORD = "@cad3myCa114L1f3";
	
	private ObsService obsService = Context.getObsService();
	
	private PatientService patientService = Context.getPatientService();
	
	private LocationService locationService = Context.getLocationService();
	
	private Location location;
	
	public void connectToDatabaseAndSelectData() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Load the MSSQL JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Establish a connection to the database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            if (connection != null) {
                // SQL query to select data
                String sqlQuery = "SELECT TOP 2 * FROM Tama_symptom WHERE PatientID IN (SELECT PatientId FROM Tama_NewPatientInfo)";
                // Create a prepared statement with the query
                preparedStatement = connection.prepareStatement(sqlQuery);
                // Execute the query
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Process and print the data
                    // Replace the column names from the icea views  with actual column names from your cfl database
                
                    int patientID = resultSet.getInt("PatientID");
                    String ConceptRash = resultSet.getString("Rash");
                    String ConceptParaparesis = resultSet.getString("Paraparesis");
                    String ConceptDiarrhea = resultSet.getString("Diarrhea");
                    int  ConceptDiabates = resultSet.getInt("Diabates");
                    String visitDate = resultSet.getString("visitDate");

//Transform part
                 int Rash = ConceptRash== null ? 1066 : 1065;
                 int Paraparesis = ConceptParaparesis== "No" ? 1066 : 1065;                      
                 int Diabates = ConceptDiabates== 2 ? 1066 : 1065;
                 int Diarrhea = ConceptDiarrhea==null ? 1066 : 1065;


                System.out.println("PatientID: " + patientID);
                System.out.println("Rash: " + Rash);
                System.out.println("Paraparesis: " + Paraparesis);
                System.out.println("Diabates: " + Diabates);
                System.out.println("Diarrhea: " + Diarrhea);
                System.out.println("visitDate: " + visitDate);


                
/// Load part
Encounter encounter = new Encounter();

EncounterType encounterType = new EncounterType();
String encountertypeName = "Symptom Form";
//String encounterTypeDescription = "encounter form";
encounterType.setName(encountertypeName);



//patient
Patient patient = new Patient();
//PersonName patientName = new PersonName();
//patientName.setGivenName("31563_givenName");
//patientName.setMiddleName("31563_givenName");
//patient.addName(patientName);

//Date date = new Date();
//patient.setBirthdateEstimated(true);
//patient.setBirthdate(date);

patient.setPatientId(31563);

//PersonAddress address = new PersonAddress();
///address.setAddress1("kampala Najjera");
//address.setPreferred(false);
//patient.addAddress(address);

String IdentifierTypeUuid = "05a29f94-c0ed-11e2-94be-8c13b969e334";
String LocationUuid = "3b7617c9-778f-4f48-83e7-5514eb6ed946";
PatientIdentifierType identifierType = patientService.getPatientIdentifierTypeByUuid(IdentifierTypeUuid);
PatientIdentifier identifier = new PatientIdentifier();
identifier.setIdentifier("31563");
identifier.setIdentifier("05a29f94-c0ed-11e2-94be-8c13b969e334");

identifier.setIdentifierType(identifierType);

Location location = locationService.getLocationByUuid(LocationUuid);
identifier.setLocation(location);
patient.addIdentifier(identifier);


//encounter

encounter.setEncounterType(encounterType);  //                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            Set the appropriate encounter type
encounter.setPatient(patient);  // Set the appropriate patient
Date encounterDatetime = null;
encounter.setEncounterDatetime(encounterDatetime);  // Set the encounter datetime
encounter.setLocation(location);  // Set the appropriate location


// Create an Obs object for "Rash"
Obs obs = new Obs();
obs.setPerson(encounter.getPatient());  // Set the person (patient) associated with the observation
obs.setEncounter(encounter);
obs.setValueCoded(Context.getConceptService().getConcept("Rash"));  // Replace with the UUID of "Rash" concept
obs.setObsDatetime(encounter.getEncounterDatetime());
obs.setCreator(Context.getAuthenticatedUser());

// Set the value for "Rash" based on your transformation
if (ConceptRash == null) {
    obs.setValueCoded(Context.getConceptService().getConcept(Rash));  // Replace with the appropriate concept UUID
} 

// Save the Obs
obsService.saveObs(obs, null);

// Add the Obs to the encounter
encounter.addObs(obs);

// Save the Encounter
Context.getEncounterService().saveEncounter(encounter);

    }
                Logger.getAnonymousLogger().info("Connected to the MSSQL database!");
            } else {
                Logger.getAnonymousLogger().severe("Failed to connect to the database.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getAnonymousLogger().severe("Database connection or query error: " + e.getMessage());
        } finally {
            // Close the database resources when done
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    Logger.getAnonymousLogger().severe("Error closing result set: " + e.getMessage());
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    Logger.getAnonymousLogger().severe("Error closing prepared statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getAnonymousLogger().severe("Error closing database connection: " + e.getMessage());
                }
            }
        }
    }
}
