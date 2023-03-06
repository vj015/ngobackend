package com.ngobackend.dto;


public class InternDTO {


	private int id;

	private String name;

	private String address;

	private String gender;

	private String city;

	private String state;

	private String reason;

	private String email;

	private String college;

	private String expertise;

	private long dob;

	private String education;

	private long pincode;

	private long cnumber;

	private long wnumber;

	public InternDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternDTO(int id, String name, String address, String gender, String city, String state, String reason,
			String email, String college, String expertise, long dob, String education, long pincode, long cnumber,
			long wnumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.reason = reason;
		this.email = email;
		this.college = college;
		this.expertise = expertise;
		this.dob = dob;
		this.education = education;
		this.pincode = pincode;
		this.cnumber = cnumber;
		this.wnumber = wnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public long getDob() {
		return dob;
	}

	public void setDob(long dob) {
		this.dob = dob;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public long getCnumber() {
		return cnumber;
	}

	public void setCnumber(long cnumber) {
		this.cnumber = cnumber;
	}

	public long getWnumber() {
		return wnumber;
	}

	public void setWnumber(long wnumber) {
		this.wnumber = wnumber;
	}

	@Override
	public String toString() {
		return "InternDTO [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", city="
				+ city + ", state=" + state + ", reason=" + reason + ", email=" + email + ", college=" + college
				+ ", expertise=" + expertise + ", dob=" + dob + ", education=" + education + ", pincode=" + pincode
				+ ", cnumber=" + cnumber + ", wnumber=" + wnumber + "]";
	}
	
	

}
