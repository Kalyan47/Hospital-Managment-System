package com.example.katari.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor_registration")
public class DoctorRegistrationEntity {
	private long id;
	private String name;
	private double mobile;
	private String email;
	private String password;
	private String specalist;
	private String location;
	
	public DoctorRegistrationEntity() {
		super();
	}
	
	@Override
	public String toString() {
		return "DoctorRegistrationEntity [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + ", specalist=" + specalist + ", location=" + location + "]";
	}
	public DoctorRegistrationEntity(long id, String name, double mobile, String email, String password, String specalist,
			String location) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.specalist = specalist;
		this.location = location;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="mobile")
	public double getMobile() {
		return mobile;
	}
	public void setMobile(double mobile) {
		this.mobile = mobile;
	}
	@Column(name="email" ,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="specalist")
	public String getSpecalist() {
		return specalist;
	}
	public void setSpecalist(String specalist) {
		this.specalist = specalist;
	}
	@Column(name="location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
