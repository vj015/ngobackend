package com.ngobackend.dto;


public class UserDTO {
	

	private int id;

	private String name;

	private String address;

	private String password;

	private String city;

	private String gender;

	private long cnumber;

	private long wnumber;

	private long dob;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int id, String name, String address, String password, String city, String gender, long cnumber,
			long wnumber, long dob) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.password = password;
		this.city = city;
		this.gender = gender;
		this.cnumber = cnumber;
		this.wnumber = wnumber;
		this.dob = dob;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public long getDob() {
		return dob;
	}

	public void setDob(long dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", address=" + address + ", password=" + password + ", city="
				+ city + ", gender=" + gender + ", cnumber=" + cnumber + ", wnumber=" + wnumber + ", dob=" + dob + "]";
	}
	
	
	


}
