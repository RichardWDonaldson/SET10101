package model;

public class Ambulance {

	private int id;
private String type;
private String driver;
private String support;
private String location;
public Ambulance(int id, String type, String driver, String support, String location) {
	super();
	this.id = id;
	this.type = type;
	this.driver = driver;
	this.support = support;
	this.location = location;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDriver() {
	return driver;
}
public void setDriver(String driver) {
	this.driver = driver;
}
public String getSupport() {
	return support;
}
public void setSupport(String support) {
	this.support = support;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}


@Override
public String toString() {
	
	String s = "Ambulance ID: " +  id 
			+ "\t" + " Type: " + type 
			+ "\t" + " Location: " + location;
	
	return s;
	
	
}




}
