package com.example.katari.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.katari.Entity.DoctorAppointmentsList;
import com.example.katari.Entity.PatientRegistrationForm;
import com.example.katari.Entity.ReceptionistRegistrationEntity;
import com.example.katari.Repository.DoctorAppointmentsRepo;

@Service
public class DoctorAppointmentsService {
	
	@Autowired
	private DoctorAppointmentsRepo dar;
	public void sendAppointmentsToDoctor(DoctorAppointmentsList dal) {
		
		dar.save(dal);
		
	}
	public List<DoctorAppointmentsList> getDoctorAppointmentsList(){
		return dar.findAll();
		
	}
	public DoctorAppointmentsList getDoctorAppointmentsById(long id) {
		return dar.findById(id).get();
		
	}
	

}
