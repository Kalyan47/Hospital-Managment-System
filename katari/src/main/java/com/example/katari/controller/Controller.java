package com.example.katari.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.katari.Entity.PatientRegistrationForm;
import com.example.katari.Service.RegistrationService;

@RestController
@RequestMapping("/")
public class Controller {

	ModelAndView model=new ModelAndView();

	private PatientRegistrationForm re;
	@Autowired
	private RegistrationService service;
	
	

	@GetMapping("/")
	public ModelAndView index() {
		model.setViewName("index.html");
		return model;
	}
	
	@GetMapping("/appointment")
	public ModelAndView appointment() {
		ModelAndView model=new ModelAndView();
		model.setViewName("appointment.html");
		return model;
	}
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView model=new ModelAndView();
		model.setViewName("login.html");
		return model;
	}
	
	
	@GetMapping("/doctor_login")
	public ModelAndView doctor_login() {
		ModelAndView model=new ModelAndView();
		model.setViewName("doctor_login.html");
		return model;
	}
	
	@GetMapping("/admin_login")
	public ModelAndView admin_login() {
		ModelAndView model=new ModelAndView();
		model.setViewName("admin_login.html");
		return model;
	}
	@PostMapping("/admin_index")
	public ModelAndView admin_index() {
		ModelAndView model=new ModelAndView();
		model.setViewName("admin_index.html");
		return model;
	}
	
	
	@PostMapping("/registration")
	public ModelAndView setData(PatientRegistrationForm re)
	{
		System.out.println(re.getLocation()+" "+re.getName());
		service.putData(re);
		model.setViewName("appointment.html");
		String success="Your Appointment sent Succesfully";
		model.addObject("Success",success);

		return model;
	}
	
	@GetMapping("/receptionist_login")
	public ModelAndView receptionist_login() {
		ModelAndView model=new ModelAndView();
		model.setViewName("receptionist_login.html");
		return model;
	}
	

}
