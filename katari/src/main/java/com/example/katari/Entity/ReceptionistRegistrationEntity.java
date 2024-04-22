package com.example.katari.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="receptionist_registration")
public class ReceptionistRegistrationEntity {
	private long id;
	private String name;
	private double mobile;
	private String email;
	private String password;
	private String address;
	private String qualification;
	
	public ReceptionistRegistrationEntity() {
		super();
	}
	public ReceptionistRegistrationEntity(long id, String name, double mobile, String email, String password,
			String address, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.address = address;
		this.qualification = qualification;
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
	@Column(name="email")
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
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="qualification")
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "ReceptionistRegistrationEntity [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", qualification=" + qualification + "]";
	}

}
