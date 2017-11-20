package util;

public enum Job {
	Student("Student"), 
	Employed("Employed"),
	Unemployed("Unemployed");
	
	private String jobstatus;
	
	Job(String jobstatus){
		this.jobstatus = jobstatus;
	}
	
	public String toString() {
		return this.jobstatus;
	}
}
