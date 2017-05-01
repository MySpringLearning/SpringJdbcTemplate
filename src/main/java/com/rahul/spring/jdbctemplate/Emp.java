package com.rahul.spring.jdbctemplate;

public class Emp {
	
	private long id;
	private String bdate;
	private String fname;
	private String lname;
	private String gender;
	private String hdate;
	
	public Emp(){}

	public Emp(long id, String bdate, String fname, String lname, String gender, String hdate) {
		super();
		this.id = id;
		this.bdate = bdate;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.hdate = hdate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", bdate=" + bdate + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender
				+ ", hdate=" + hdate + "]";
	}
	
}
