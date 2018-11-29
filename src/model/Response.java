package model;

public class Response {
	
	Request request;
	
	String responceNotes;
	
	Hospital hospital;

	public Response(Request request, String responceNotes, Hospital hospital) {
		super();
		this.request = request;
		this.responceNotes = responceNotes;
		this.hospital = hospital;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getResponceNotes() {
		return responceNotes;
	}

	public void setResponceNotes(String responceNotes) {
		this.responceNotes = responceNotes;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Response [request=" + request + ", responceNotes=" + responceNotes + ", hospital=" + hospital + "]";
	}
	
	
	
	
	
	
	
	

}
