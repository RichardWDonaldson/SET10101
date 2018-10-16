package model;

public class Paramedic {

	private String id;
private String firstName;
private String surName;
private String role;
private String grade;
public Paramedic(String id, String firstName, String surName, String role, String grade) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.surName = surName;
	this.role = role;
	this.grade = grade;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
@Override
public String toString() {
	return "Paramedic [id=" + id + ", firstName=" + firstName + ", surName=" + surName + ", role=" + role + ", grade="
			+ grade + "]";
}



}
