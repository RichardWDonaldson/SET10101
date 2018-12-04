package model;

public class Location {
	private String street;
	private String postcode;
	public Location(String street, String postcode) {
		super();
		this.street = street;
		this.postcode = postcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	@Override
	public String toString() {
		
		String s = street + "/" + postcode;
		
		return s;
	
		
	}
	
	

}
