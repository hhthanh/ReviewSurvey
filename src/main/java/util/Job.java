package util;

public enum Job {
	STUDENT("student"), 
	EMPLOYED("employed"),
	UNEMPLOYED("unemployed");
	
	private String jobstatus;
	
	Job(String jobstatus){
		this.jobstatus = jobstatus;
	}
	
	public String toString() {
		return this.jobstatus;
	}
}
