package com.example.katari.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.katari.Entity.DoctorAppointmentsList;

@Repository
public interface DoctorAppointmentsRepo extends JpaRepository<DoctorAppointmentsList,Long> {

}
