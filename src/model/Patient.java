package model;

public class Patient {
	
	private String CHINumber;
	private String firstName;
private String surName;
private String Address;
private String contactNumber;
private String medicalCondition;

public Patient(String cHINumber, String firstName, String surName, String address, String contactNumber,
		String medicalCondition) {
	super();
	CHINumber = cHINumber;
	this.firstName = firstName;
	this.surName = surName;
	Address = address;
	this.contactNumber = contactNumber;
	this.medicalCondition = medicalCondition;
}

public String getCHINumber() {
	return CHINumber;
}

public void setCHINumber(String cHINumber) {
	CHINumber = cHINumber;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getSurName() {
	return surName;
}

public void setSurName(String surName) {
	this.surName = surName;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public String getContactNumber() {
	return contactNumber;
}

public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}

public String getMedicalCondition() {
	return medicalCondition;
}

public void setMedicalCondition(String medicalCondition) {
	this.medicalCondition = medicalCondition;
}

@Override
public String toString() {
	return "Patient [CHINumber=" + CHINumber + ", firstName=" + firstName + ", surName=" + surName + ", Address="
			+ Address + ", contactNumber=" + contactNumber + ", medicalCondition=" + medicalCondition + "]";
}






}
