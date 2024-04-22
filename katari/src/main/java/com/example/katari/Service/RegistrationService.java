package com.example.katari.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.katari.Entity.PatientRegistrationForm;
import com.example.katari.Repository.RegistrationRepository;
@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repository;
	
	public void putData(PatientRegistrationForm re) {
		System.out.println("service:"+re.getEmail());
		repository.save(re);
	}

	public void deletePatientById(long id) {
		repository.deleteById(id);
	}

}
