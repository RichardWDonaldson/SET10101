package model;

import java.util.Date;

public class Incident {

	private int id;
	private Patient patient;
	private Date date;
	
	private String notes;

	public Incident(int id, Patient patient, Date date, String notes) {
		super();
		this.id = id;
		this.patient = patient;
		this.date = date;
		this.notes = notes;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getId() {
		return id;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
//TODO clean Tostring()
	@Override
	public String toString() {
	
		String s = "ID: " + id + "\t" + "Date: " + date;
		
		return s;
		
	
	}


	
	
	
	
	
	
}
