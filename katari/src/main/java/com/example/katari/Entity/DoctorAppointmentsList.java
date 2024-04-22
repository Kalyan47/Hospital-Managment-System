package com.example.katari.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="send_appointments_to_doctor")
public class DoctorAppointmentsList {
	private long id;
	private String name;
	private double mobile;
	private String email;
	private String specification;
	private String location;
	private String date;
	private String time;
	private String status;
	
	public DoctorAppointmentsList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorAppointmentsList(long id, String name, double mobile, String email, String specification,
			String location, String date, String time) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.specification = specification;
		this.location = location;
		this.date = date;
		this.time = time;
	}
	@Override
	public String toString() {
		return "DoctorAppointmentsList [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", specification=" + specification + ", location=" + location + ",status= "+ status + ", date=" + date + ", time=" + time
				+ "]";
	}
	@Id
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
	
	@Column(name="specification")
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	@Column(name="location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Column(name="time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
