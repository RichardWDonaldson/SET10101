package model;

public class Patient {
	
	private String chiNumber;
	private String name;
	private String dob;
	private String gender;
	private String phone1;
	private String phone2;
	private String houseNumber;
	private String line1;
	private String line2;
	private String town;
	private String postcode;
	
	public Patient(String chiNumber, String name, String dob, String gender, String phone1, String phone2,
			String houseNumber, String line1, String line2, String town, String postcode) {
		super();
		this.chiNumber = chiNumber;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.houseNumber = houseNumber;
		this.line1 = line1;
		this.line2 = line2;
		this.town = town;
		this.postcode = postcode;
	}

	public String getChiNumber() {
		return chiNumber;
	}

	public void setChiNumber(String chiNumber) {
		this.chiNumber = chiNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	
	//TODO Clean up ToString()
	@Override
	public String toString() {
		return "Patient [chiNumber=" + chiNumber + ", name=" + name + ", dob=" + dob + ", gender=" + gender
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", houseNumber=" + houseNumber + ", line1=" + line1
				+ ", line2=" + line2 + ", town=" + town + ", postcode=" + postcode + "]";
	}

	






}
