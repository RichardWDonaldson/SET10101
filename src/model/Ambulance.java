package model;

public class Ambulance {

	private String id;

private Paramedic driver;
private Paramedic support;
public Ambulance(String id, Paramedic driver, Paramedic support) {
	super();
	this.id = id;
	this.driver = driver;
	this.support = support;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Paramedic getDriver() {
	return driver;
}
public void setDriver(Paramedic driver) {
	this.driver = driver;
}
public Paramedic getSupport() {
	return support;
}
public void setSupport(Paramedic support) {
	this.support = support;
}
@Override
public String toString() {
	return "Ambulance [id=" + id + ", driver=" + driver + ", support=" + support + "]";
}





}
