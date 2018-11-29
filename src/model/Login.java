package model;

public class Login {
	
	String ambulanceID;
	String driverID;
	String supportID;
	public Login(String ambulanceID, String driverID, String supportID) {
		super();
		this.ambulanceID = ambulanceID;
		this.driverID = driverID;
		this.supportID = supportID;
	}
	public String getAmbulanceID() {
		return ambulanceID;
	}
	public void setAmbulanceID(String ambulanceID) {
		this.ambulanceID = ambulanceID;
	}
	public String getDriverID() {
		return driverID;
	}
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}
	public String getSupportID() {
		return supportID;
	}
	public void setSupportID(String supportID) {
		this.supportID = supportID;
	}
	@Override
	public String toString() {
		return "Login [ambulanceID=" + ambulanceID + ", driverID=" + driverID + ", supportID=" + supportID + "]";
	}
	
	
	
	
	
	
	
	

}
