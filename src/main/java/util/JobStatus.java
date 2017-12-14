package util;

public enum JobStatus {
	Student("Student"), Employed("Employed"), Unemployed("Unemployed");

	private String jobStatus;

	JobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String toString() {
		return jobStatus;
	}
}
