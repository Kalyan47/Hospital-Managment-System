package com.example.katari.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.katari.Entity.DoctorRegistrationEntity;

@Repository
public interface DoctorRegistrationRepo extends JpaRepository<DoctorRegistrationEntity,Long>{


}
