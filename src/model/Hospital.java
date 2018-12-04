package model;

public class Hospital {
	
	int hospitalID;
	
	String location;

	public Hospital(int hospitalID, String location) {
		super();
		this.hospitalID = hospitalID;
		this.location = location;
	}

	public int getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		
		String s = location + "ID: " + hospitalID;
		
		return s;
		
		
	
	}
	
	
	
	
	
	
	

}
