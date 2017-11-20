package model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import util.Job;

public class ReviewSurvey {
	
	private String fullname;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthday;
	
	private Character sex;
	private Job jobStatus;
	private String country;
	private Float rating_score;
	private String rating_content;
	
	public ReviewSurvey() {
		
	}
	
	public ReviewSurvey(String fullname, Job jobStatus, Date birthday, Character sex, Float rating_score,
			String rating_content) {
		super();
		this.fullname = fullname;
		this.jobStatus = jobStatus;
		this.birthday = birthday;
		this.sex = sex;
		this.rating_score = rating_score;
		this.rating_content = rating_content;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Job getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Job jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Float getRating_score() {
		return rating_score;
	}

	public void setRating_score(Float rating_score) {
		this.rating_score = rating_score;
	}

	public String getRating_content() {
		return rating_content;
	}

	public void setRating_content(String rating_content) {
		this.rating_content = rating_content;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
