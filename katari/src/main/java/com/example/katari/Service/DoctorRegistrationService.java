package com.example.katari.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.katari.Entity.DoctorRegistrationEntity;
import com.example.katari.Repository.DoctorRegistrationRepo;

@Service
public class DoctorRegistrationService {
	
	@Autowired
	private DoctorRegistrationRepo drr;
	public void addDoctorData(DoctorRegistrationEntity dre) {
		drr.save(dre);
	}
	public List<DoctorRegistrationEntity> getDoctorsList(){
		return drr.findAll();
		
	}
	public DoctorRegistrationEntity getDoctorById(long id) {
		return drr.findById(id).get();
	}
	public void deleteDoctorById(long id) {
		drr.deleteById(id);
	}
}
