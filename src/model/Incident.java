package model;

import java.util.Date;

public class Incident {

	
	private Patient patient;
	private Date date;
	
	private String notes;

	public Incident(Patient patient, Date date, String notes) {
		super();
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

	@Override
	public String toString() {
		return "Incident [patient=" + patient + ", date=" + date + ", notes=" + notes + "]";
	}
	
	
	
	
	
	
}
