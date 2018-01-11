package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import util.Country;
import util.JobStatus;

public class ReviewSurvey {
	
	private Integer id;
	private String fullname;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthday;
	private List<Product> productList;
	private Character sex;
	private JobStatus jobStatus;
	private Country country;
	private Float rating_score;
	private String rating_content;
	
	public ReviewSurvey() {
		this.productList = new ArrayList<Product>();
	}
	
	public ReviewSurvey(Integer id) {
		this.id = id;
		this.productList = new ArrayList<Product>();
	}
	
	public ReviewSurvey(String fullname, JobStatus jobStatus, Country country, Date birthday, Character sex, Float rating_score,
			String rating_content) {
		super();
		this.country = country;
		this.fullname = fullname;
		this.jobStatus = jobStatus;
		this.birthday = birthday;
		this.sex = sex;
		this.rating_score = rating_score;
		this.rating_content = rating_content;
		this.productList = new ArrayList<Product>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public JobStatus getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(JobStatus jobStatus) {
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
