package com.example.katari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.katari.Entity.DoctorRegistrationEntity;
import com.example.katari.Entity.ReceptionistRegistrationEntity;
import com.example.katari.Service.DoctorAppointmentsService;
import com.example.katari.Service.DoctorRegistrationService;
import com.example.katari.Service.ReceptionistRegistrationService;
import com.example.katari.Service.RegistrationService;

@RestController
public class AdminController {
	
	ModelAndView mode= new ModelAndView();
	
	@Autowired
	private ReceptionistRegistrationService rrs;
	
	private DoctorRegistrationEntity dre;
	@Autowired
	private DoctorRegistrationService drs;
	
	@RequestMapping("/edit_receptionist/{id}")
	public ModelAndView edit_receptionist(@PathVariable("id") long id, Model model) {
		
		
		ReceptionistRegistrationEntity rre=rrs.getReceptionistById(id);
		model.addAttribute("edit_receptionist",rre);
		mode.setViewName("edit_receptionist.html");
		return mode;
	}
	@RequestMapping("/edit_doctor/{id}")
	public ModelAndView edit_doctor(@PathVariable("id") long id,Model model) {
		
		DoctorRegistrationEntity dre=drs.getDoctorById(id);
		model.addAttribute("edit_doctor",dre);
		mode.setViewName("edit_doctor.html");
		return mode;
		
	}
	
	@GetMapping("/doctor_registration")
	public ModelAndView doctor_registration() {
		mode.setViewName("doctor_registration.html");
		return mode;
	}
	
	@PostMapping("/doctor_registration_data")
	public RedirectView setData(DoctorRegistrationEntity dre)
	{
		drs.addDoctorData(dre);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/doctors_list");
		return redirectView;		
	}

	@GetMapping("/doctors_list")
	public ModelAndView doctors_list() {
		List<DoctorRegistrationEntity> list=drs.getDoctorsList();
		mode.setViewName("doctors_list.html");
		mode.addObject("doctors_list",list);
		return mode;
	}
	@GetMapping("/receptionist_registration")
	public ModelAndView receptionist_registration() {
		mode.setViewName("receptionist_registration.html");
		return mode;
	}
	@PostMapping("/receptionist_registration_data")
	public RedirectView setData(ReceptionistRegistrationEntity rre ) {
		rrs.addReceptionistData(rre);
		
		RedirectView redirectView =new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/receptionists_list");
		return redirectView;
		
		
	}
	@GetMapping("/receptionists_list")
	public ModelAndView receptionist_list() {
		List <ReceptionistRegistrationEntity> list=rrs.getReceptionistsLists();
		mode.setViewName("receptionists_list.html");
		mode.addObject("receptionists_list",list);
		return mode;
	}
	@RequestMapping("/delete_receptionist/{id}")
	public RedirectView delete_receptionist(@PathVariable("id") long id) {
		rrs.deleteReceptionistById(id);
		RedirectView redirectView =new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/receptionists_list");
		return redirectView;
		
	}
	
	@RequestMapping("/delete_doctor/{id}")
	public RedirectView delete_doctor(@PathVariable("id") long id) {
		drs.deleteDoctorById(id);
		RedirectView redirectView =new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/doctors_list");
		return redirectView;
		
	}

}
