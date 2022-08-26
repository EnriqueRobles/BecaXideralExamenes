package com.client.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rest.model.Profesor;
import com.client.rest.service.ProfesorService;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

	// need to inject our profesor service
	@Autowired
	private ProfesorService customerService;
	
	@GetMapping("/list")
	public String listProfesor(Model theModel) {
		
		// get customers from the service
		List<Profesor> theProfesor = customerService.getProfesor();
				
		// add the profesor to the model
		theModel.addAttribute("profesor", theProfesor);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Profesor theProfesor = new Profesor();
		
		theModel.addAttribute("profesor", theProfesor);
		
		return "customer-form";
	}
	
	@PostMapping("/saveProfesor")
	public String saveProfesor(@ModelAttribute("profesor") Profesor theProfesor) {
		
		// save the customer using our service
		customerService.saveProfesor(theProfesor);	
		
		return "redirect:/profesor/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("profesorId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Profesor theProfesor = customerService.getProfesor(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("profesor", theProfesor);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteProfesor(@RequestParam("profesorId") int theId) {
		
		// delete the customer
		customerService.deleteProfesor(theId);
		
		return "redirect:/profesor/list";
	}
}










