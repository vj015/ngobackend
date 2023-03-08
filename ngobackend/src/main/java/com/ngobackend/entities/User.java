package com.ngobackend.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "User")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Contactnumber")
	private long cnumber;
	
	@Column(name = "Whatsappnumber")
	private long wnumber;
	
	@Column(name = "DOB")
	private long dob;
	
	@Column(name = "Notify")
	private boolean notify;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	joinColumns = @JoinColumn(name="user",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="role", referencedColumnName = "id"))
	private Set<Role> role=new HashSet<>();
	

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public User(int id, String name, String address, String password, String city, String gender, long cnumber,
			long wnumber, long dob, boolean notify) {
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
		this.notify = notify;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
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

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", password=" + password + ", city="
				+ city + ", gender=" + gender + ", cnumber=" + cnumber + ", wnumber=" + wnumber + ", dob=" + dob
				+ ", notify=" + notify + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return(this.role.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		String s=String.valueOf(this.cnumber);
		return s;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
