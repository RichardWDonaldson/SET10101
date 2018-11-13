package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Incident;
import model.Patient;

public class Controller {
	
	Database database;
	Connection con;
	Controller controller;
	
	
	public void initialize() throws IOException {
		//TODO data validation
		database = new Database();
		con = database.getConnection();
			
	}
	
	
	public void testQuery() {
		//TODO delete when finished
		try {
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from patientRecords");  
		while(rs.next()) {
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); }
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Patient findPatient(String chi) {
		//Add validation
		
		String[] output = new String[7];
		String firstName, surname,  address, contactNumber, medicalCondition;
		try {
			
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from patientRecords where patient_id = " + chi );
			
			if(rs != null) {
			
			while(rs.next()) {
				for(int i=1;i<rs.getMetaData().getColumnCount(); i++) {
					
					output[i] = rs.getString(i);
						
				}
				 
				}
			} else {
				System.out.println("No results found");
			}
			firstName = output[2];
			surname = output[3];
			address = output[4];
			contactNumber = output[5];
			medicalCondition = output[6];
			Patient patient = new Patient(chi, firstName, surname, address, contactNumber, medicalCondition);
			
			return patient;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
//	public void testQuery() {
//		try {
//		Statement stmt=con.createStatement();  
//		ResultSet rs=stmt.executeQuery("select * from patientRecords");  
//		while(rs.next()) {
//		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); }
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	public void addIncident(Incident incident) {
		//TODO Add check to see if insert statement worked, add data validation to input
	try {
		
		Statement stmt = con.createStatement();
		
	int i = stmt.executeUpdate("insert into incidentrecords (patient_id, date, notes) values ( '" + incident.getPatient().getCHINumber() + "', '" + incident.getDate() + "', '" + incident.getNotes() + "')" );
		 	
	if(i > 0) {
		System.out.println("Update Sucessful");
	} else {
		System.out.println("Failure, try again");
	}
	      
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
		
	}
	
	public void addPatient(Patient patient) {
//TODO Add input validation		

		try {
			Statement stmt = con.createStatement();
			
			int i = stmt.executeUpdate("insert into patientrecords (patient_id, first_name,surname, address, phone_number, notes) values ('" + patient.getCHINumber() + "', '" + patient.getFirstName() + "', '"+patient.getSurName() + "', '" + patient.getAddress() + "', '" + patient.getContactNumber() + "', '" + patient.getMedicalCondition() + "')");
		
			if(i > 0) {
				System.out.println("Update Sucessful");
			} else {
				System.out.println("Failure, try again");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
