package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Ambulance;
import model.Hospital;
import model.Incident;
import model.Login;
import model.Patient;
import model.Request;
import model.Response;

public class Controller {
	
	Database database;
	Connection con;
	Controller controller;
	
	ArrayList<Request> requests = new ArrayList<Request>();
	ArrayList<Incident> arrayIncidents = new ArrayList<Incident>();
	ArrayList<Patient> patients = new ArrayList<Patient>();
	List<Integer> incidents = new ArrayList<Integer>();
	
	public void initialize() throws IOException {
		//TODO data validation
		try {
		database = new Database();
		con = database.getConnection();
		
		
		} catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Database Error - Could not connect to Database", "Critical Error", 0);
		}
			
	}
	
	public Patient findPatient(String chi) {
		//Add validation
		
		String[] output = new String[12];
		String name, dob, gender, phone1, phone2, houseNumber, line1, line2, town, postcode;
		try {
			
			con = database.getConnection();
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
			name = output[2];
			dob = output[3];
			gender = output[4];
			phone1 = output[5];
			phone2 = output[6];
			houseNumber = output[7];
			line1 = output[8];
			line2 = output[9];
			town = output[10];
			postcode = output[11];
			
			Patient patient = new Patient(chi, name, dob, gender, phone1, phone2, houseNumber, line1, line2, town, postcode);
			
			return patient;
			
		} catch (SQLException e) {
			System.out.println("Controller: findPatient error");
			JOptionPane.showMessageDialog(null, "Database error: Please Contact System Admin", "Critical Error", 0);
			e.printStackTrace();
		} catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Input/output Error- Contact System Admin", "Critical Error", 0);
		}
		
		
		return null;
	}
	
	
	
	public boolean addIncident(Incident incident) {
		//TODO Add check to see if insert statement worked, add data validation to input
	try {
		con = database.getConnection();
		Statement stmt = con.createStatement();
		
	int i = stmt.executeUpdate("insert into incidentrecords (patient_id, date, notes) values ( '" + incident.getPatient().getChiNumber() + "', '" + incident.getDate() + "', '" + incident.getNotes() + "')" );
		 	
	if(i > 0) {
		System.out.println("Update Sucessful");
		return true;
	} else {
		System.out.println("Update Failed");
		JOptionPane.showMessageDialog(null, "Update failed: Please try again", "Critical Error", 0);
	}
	      
		
		
	} catch (SQLException e) {
		System.out.println("Controller: addIncident error");
		JOptionPane.showMessageDialog(null, "Database error: Please Contact System Admin", "Critical Error", 0);
		e.printStackTrace();
	} catch (NullPointerException ex) {
		JOptionPane.showMessageDialog(null, "Input/output Error- Contact System Admin", "Critical Error", 0);
	}
	return false;
		
		
		
	}
	
	public boolean addPatient(Patient patient) {
//TODO Add input validation		

		try {
			con = database.getConnection();
			Statement stmt = con.createStatement();
			
			int i = stmt.executeUpdate("insert into patientrecords "
					+ "values ('" + patient.getChiNumber() 
					+ "', '" + patient.getName() 
					+ "', '"+patient.getDob() 
					+ "', '" + patient.getGender() 
					+ "', '" + patient.getPhone1() 
					+ "', '" + patient.getPhone2() 
					+ "', '" + patient.getHouseNumber()
					+ "', '" + patient.getLine1()
					+ "', '" + patient.getLine2()
					+ "', '" + patient.getTown()
					+ "', '" + patient.getPostcode()
					+ "')");
		
			if(i > 0) {
				System.out.println("Update Sucessful");
				return true;
			} else {
				System.out.println("Failure, try again");
				JOptionPane.showMessageDialog(null, "Input/output Error- Contact System Admin", "Critical Error", 0);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error: Contact System Admin", "Critical Error", 0);
		} catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Input/output Error- Contact System Admin", "Critical Error", 0);
		}
		return false;
	}
	
	public ArrayList<Ambulance> getAmbulance() throws IOException {
		ArrayList<Ambulance> al = new ArrayList<Ambulance>();
		
		try {
			con = database.getConnection();
			Statement stmt=con.createStatement();
			
			
			
			
			ResultSet rs=stmt.executeQuery("select * from ambulancerecords");  
			
			while(rs.next()) {
				Ambulance ambulance = new Ambulance(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				al.add(ambulance);
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) + rs.getString(4)); }
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Database error: Contact System Admin", "Critical Error", 0);
				e.printStackTrace();
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Input/Output error: Contact System Admin", "Critical Error", 0);
				ex.printStackTrace();
			}
		
		
		return al;
		
	}
	
	
	public boolean addRequest(Request request) {
		try {
			con = database.getConnection();
			Statement stmt = con.createStatement();
			
			
			
			
		int i = stmt.executeUpdate("insert into requestrecords (ambulance_id, incident_id) values ( " 
		+ request.getAmbulance().getId() + "," + request.getIncident().getId() + ")");	
			 
		if(i > 0) {
			System.out.println("Update Sucessful");
			return true;
		} else {
			System.out.println("Failure, try again");
			JOptionPane.showMessageDialog(null, "Input/output Error- Contact System Admin", "Critical Error", 0);
		}
		      
			
			
		} catch (SQLException e) {
		
			JOptionPane.showMessageDialog(null, "Database error: Contact System Admin", "Critical Error", 0);
			e.printStackTrace();
		} catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Input/output Error- Contact System Admin", "Critical Error", 0);
		}
		return false;
		
		
		
	}
	
	
	public Ambulance getCurrentAmbulance(int id) {
		
		Ambulance ambulance = null;
		try {
			con = database.getConnection();
			Statement stmt=con.createStatement();
			
			
			
			
			ResultSet rs=stmt.executeQuery("select * from ambulancerecords where ambulance_id = " + id);  
			
			while(rs.next()) {
				ambulance = new Ambulance(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) + rs.getString(4)); }
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Database error: Contact System Admin", "Critical Error", 0);
				e.printStackTrace();
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Input/Output error: Contact System Admin", "Critical Error", 0);
				ex.printStackTrace();
			}
		
		return ambulance;
		
		
	}
	

	
	public ArrayList getRequests(Login login) {
		
		System.out.println("Get requests" + login.toString());
		System.out.println(Integer.parseInt(login.getAmbulanceID()));
		
		Ambulance currentAmbulance = getCurrentAmbulance(Integer.parseInt(login.getAmbulanceID()));
		
		try {
			con = database.getConnection();
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from requestrecords where ambulance_id = " + login.getAmbulanceID());  
			
			
				
				for(int i=0;i<rs.getMetaData().getColumnCount(); i++) {
					while(rs.next()) {
					System.out.println("Request: ID/Ambulance/Incident " + rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3));
					
					incidents.add(rs.getInt(3));
					}
				}
					
				for(int value : incidents) {
					System.out.println("Value in For each " + value);
					Incident incident = getIncident(value);
					
					arrayIncidents.add(incident);
					
					Request request = new Request(currentAmbulance, incident);
					
					requests.add(request);
					
				}
				
				
			

		
		}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Database error: Contact System Admin", "Critical Error", 0);
				e.printStackTrace();
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Input/Output error: Contact System Admin", "Critical Error", 0);
				ex.printStackTrace();
			}
		
		
		return requests;
	}
	
	
	public Incident getIncident(int id) {
		try {
			con = database.getConnection();
			Statement stmt=con.createStatement();
			
			
			System.out.println("id is " + id);
			
			ResultSet rs =stmt.executeQuery("select * from incidentrecords where id = " + id);
			
			while(rs.next()) {
			
			System.out.println("getIncident parse" + Integer.toString(rs.getInt(2)));
			
			
			Patient patient = findPatient(Integer.toString(rs.getInt(2)));
			
			patients.add(patient);
			System.out.println("get Incident " + id + " " + patient.toString() + " " + rs.getDate(3) + " " + rs.getString(4));
			Incident incident = new Incident(id, patient, rs.getDate(3), rs.getString(4));
			System.out.println("Incident " + incident.toString());
			
			return incident;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
		
	}
	
	public int getSize() {
		
		
		
		try {
			con = database.getConnection();
		Statement stmt = con.createStatement();
			
			ResultSet rs =stmt.executeQuery("SELECT LAST_INSERT_ID()");
			while(rs.next()) {
			return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;

		
	}
	
	public ArrayList<Hospital> getHospitals() {
		
		ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
		
		try {
		con = database.getConnection();
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from hospitalrecords");  
		
		while(rs.next()) {
			
			Hospital hospital = new Hospital(rs.getInt(1), rs.getString(2));
			System.out.println("Hospital" + hospital.toString());
			hospitals.add(hospital);
			
		}

		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return hospitals;
	}
	
	public boolean addResponce(Response response) {
	
		try {
			con = database.getConnection();
			Statement stmt = con.createStatement();
				
			
		int i = stmt.executeUpdate("insert into responserecord (incident_id, hospital_id, notes ) values (" 
		+ response.getRequest().getIncident().getId() 
		+ ", " 
		+ response.getHospital().getHospitalID() 
		+ ", " 
		+ response.getResponceNotes()
		+ ")");
		
		if(i > 0) {
			System.out.println("Update Sucessful");
			return true;
		} else {
			System.out.println("Failure, try again");
			JOptionPane.showMessageDialog(null, "Input/output Error- Contact System Admin", "Critical Error", 0);
		}
		
		
		
		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
		
	}
	
	
	
	
	
}
