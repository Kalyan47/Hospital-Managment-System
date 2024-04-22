package com.example.katari.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.katari.Entity.DoctorRegistrationEntity;
import com.example.katari.Entity.PatientRegistrationForm;
import com.example.katari.Entity.ReceptionistRegistrationEntity;
import com.example.katari.Repository.ReceptionistRegistrationRepo;
import com.example.katari.Repository.RegistrationRepository;

@Service
public class ReceptionistRegistrationService {
	
	@Autowired
	private ReceptionistRegistrationRepo rrr;
	
	@Autowired
	private RegistrationRepository rr;
	public void addReceptionistData(ReceptionistRegistrationEntity rre) {
		rrr.save(rre);
		
	}
	public List<PatientRegistrationForm> getAppointmentsList(){
		return rr.findAll();
		
	}

	public PatientRegistrationForm getPatientById(long id) {
		System.out.println(rr.findById(id));
		return rr.findById(id).get();
	}
	
	public List<ReceptionistRegistrationEntity> getReceptionistsLists(){
		return rrr.findAll();		
	}
	
	public ReceptionistRegistrationEntity getReceptionistById(long id) {
		return rrr.findById(id).get();
		
	}
	public void deleteReceptionistById(long id) {
		rrr.deleteById(id);
	}
	  

}
