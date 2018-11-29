package model;

public class Request {
	
	Ambulance ambulance;
	Incident incident;
	public Request(Ambulance ambulance, Incident incident) {
		super();
		this.ambulance = ambulance;
		this.incident = incident;
	}
	public Ambulance getAmbulance() {
		return ambulance;
	}
	public void setAmbulance(Ambulance ambulance) {
		this.ambulance = ambulance;
	}
	public Incident getIncident() {
		return incident;
	}
	public void setIncident(Incident incident) {
		this.incident = incident;
	}
	@Override
	public String toString() {
		return "Request [ambulance=" + ambulance + ", incident=" + incident + "]";
		
	}
	
	
	
	
	

}
