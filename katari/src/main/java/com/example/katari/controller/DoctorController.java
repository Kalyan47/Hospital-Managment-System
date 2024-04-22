package com.example.katari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.katari.Entity.DoctorAppointmentsList;
import com.example.katari.Entity.DoctorRegistrationEntity;
import com.example.katari.Entity.PatientRegistrationForm;
import com.example.katari.Service.DoctorAppointmentsService;
import com.example.katari.Service.DoctorRegistrationService;
import com.example.katari.Service.ReceptionistRegistrationService;
import com.example.katari.Service.RegistrationService;

@RestController
public class DoctorController {
	
	ModelAndView model=new ModelAndView();
	private DoctorRegistrationEntity dre;
	@Autowired
	private DoctorRegistrationService drs;
	
	@Autowired
	private RegistrationService rs;
	
	@Autowired
	private DoctorAppointmentsService das;
	@Autowired
	private ReceptionistRegistrationService rrs;
	/*
	@PostMapping("/doctor_registration")
	public ModelAndView setData(@ModelAttribute DoctorRegistrationEntity dre)
	{
		System.out.println(dre.getEmail()+" "+dre.getName());
		drs.addDoctorData(dre);
		
		model.setViewName("admin_login.html");
		return model;		
	}
	*/
	/*
	@GetMapping("/doctors_list")
	public ModelAndView doctors_list() {
		ModelAndView model=new ModelAndView();
		List<DoctorRegistrationEntity> list=drs.getDoctorsList();
		model.setViewName("doctors_list.html");
		model.addObject("doctors_list",list);
		return model;
	}
	*/
	@PostMapping("/doctor_index")
	public ModelAndView receptionist_index() {
		
		model.setViewName("doctor_index.html");
		return model;
	}

	@GetMapping("/doctor_appointments_list")
	public ModelAndView doctor_appointments_list() {
		ModelAndView model=new ModelAndView();
		List<DoctorAppointmentsList> list=das.getDoctorAppointmentsList();
		System.out.println(list);
		model.setViewName("doctor_appointments_list.html");
		model.addObject("doctor_appointments_list",list);
		return model;
	}
	@RequestMapping("/add_status_to_doctor_appointments_list/{id}")
	public RedirectView add_status_to_doctor_appointments_list(@PathVariable("id") long id) {
		System.out.println("add_status_to_doctor_appointments_list");
		DoctorAppointmentsList dal=das.getDoctorAppointmentsById(id);
		dal.setStatus("Completed");
		System.out.println(dal);
		das.sendAppointmentsToDoctor(dal);
		RedirectView redirectView =new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/doctor_appointments_list");
		return redirectView;
		
		
	}
	
	
	
	
}
