package com.example.katari.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.katari.Entity.PatientRegistrationForm;

@Repository
public interface RegistrationRepository extends JpaRepository<PatientRegistrationForm,Long>{
	
}
