package com.example.katari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.katari.Entity.DoctorAppointmentsList;
import com.example.katari.Entity.DoctorRegistrationEntity;
import com.example.katari.Entity.PatientRegistrationForm;
import com.example.katari.Entity.ReceptionistRegistrationEntity;
import com.example.katari.Service.DoctorAppointmentsService;
import com.example.katari.Service.ReceptionistRegistrationService;
import com.example.katari.Service.RegistrationService;

@RestController

public class ReceptionistController {
	
	ModelAndView model=new ModelAndView();
	

	private ReceptionistRegistrationEntity rre;
	@Autowired
	private ReceptionistRegistrationService rrs;
	
	@Autowired
	private DoctorAppointmentsService das;
	@Autowired
	private RegistrationService rs;
	
	PatientRegistrationForm prf;
	DoctorAppointmentsList dal;
	
	/*
	@PostMapping("/receptionist_registration")
	public RedirectView setData(ReceptionistRegistrationEntity rre ) {
		rrs.addReceptionistData(rre);
		
		RedirectView redirectView =new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/receptionists_list");
		return redirectView;
		
		
	}
	*/
	
	@PostMapping("/receptionist_index")
	public ModelAndView receptionist_index( ) {
		
		model.setViewName("receptionist_index.html");
		return model;
	}
	@GetMapping("/appointments_list")
	public ModelAndView appointments_list() {
		ModelAndView model=new ModelAndView();
		List<PatientRegistrationForm> list=rrs.getAppointmentsList();
		model.setViewName("appointments_list.html");
		
		model.addObject("appointments_list",list);
		
		return model;
	}
	/*
	@GetMapping("/add_appointments_to_doctor")
	public PatientRegistrationForm add_appointments_to_doctor() {
		return rrs.getPatientById(20); 
	}
	*/
	/*
	@GetMapping(value="/add_appointments_to_doctor/{id}")
	public String add_appointments_to_doctor(@PathVariable("id") int id,ModelMap modelMap ) {
		
		System.out.println("add_appointments_to_doctor");
		PatientRegistrationForm prf=rrs.getPatientById(id);
		System.out.println(prf.getId());
		DoctorAppointmentsList dal=new DoctorAppointmentsList(prf.getId(),prf.getName(),prf.getMobile(),prf.getEmail(),prf.getSpecification(),prf.getLocation(),prf.getDate(),prf.getTime());
		das.sendAppointmentsToDoctor(dal);
		
		
		
		return "redirect:/doctor_appointments_list";
	
	}
	*/
	
	@RequestMapping("/add_appointments_to_doctor/{id}")
	public RedirectView add_appointments_to_doctor(@PathVariable("id") long id) {

		System.out.println("add_appointments_to_doctor");
		PatientRegistrationForm prf=rrs.getPatientById(id);
		prf.setStatus("Approved");
		System.out.println(prf.getId());
		DoctorAppointmentsList dal=new DoctorAppointmentsList(prf.getId(),prf.getName(),prf.getMobile(),prf.getEmail(),prf.getSpecification(),prf.getLocation(),prf.getDate(),prf.getTime());
		das.sendAppointmentsToDoctor(dal);
		
		
		RedirectView redirectView =new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/appointments_list");
		return redirectView;
		
		
		
	}
	@RequestMapping("/delete_appointment_by_id/{id}")
	public RedirectView delete_appointment_by_id(@PathVariable("id") long id) {
		
		rs.deletePatientById(id);
		RedirectView redirectView =new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/appointments_list");
		return redirectView;
		
	}
	
	/*
	@RequestMapping(value="/add_appointments_to_doctor/{id}",method=RequestMethod.POST)
	public String add_appointments_to_doctor(@PathVariable Long id) {
		return "string";
	}
	*/
	/*
	@GetMapping("/receptionists_list")
	public ModelAndView receptionist_list() {
		ModelAndView model=new ModelAndView();
		List<ReceptionistRegistrationEntity> list=rrs.getReceptionistsLists();
		model.setViewName("receptionists_list.html");
		model.addObject("receptionists_list",list);
		return model;
	}
	*/
	
	
}
