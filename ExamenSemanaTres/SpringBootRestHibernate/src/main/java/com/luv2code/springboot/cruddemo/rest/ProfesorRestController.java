package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Profesor;
import com.luv2code.springboot.cruddemo.service.ProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {
	
	private ProfesorService profesorService;
	
	@Autowired
	public ProfesorRestController(ProfesorService theProfesorService) {
		profesorService = theProfesorService;
	}
	
	// expose "/profesores" and return list of profesores
	@GetMapping("/profesores")
	public List<Profesor> findAll() {
		return profesorService.findAll();
	}

	// add mapping for GET /profesores/{profesorId}
	
	@GetMapping("/profesores/{profesorId}")
	public Profesor getProfesor(@PathVariable int profesorId) {
		
		Profesor theProfesor = profesorService.findById( profesorId);
		
		if (theProfesor == null) {
			throw new RuntimeException("Profesor id no encontrado - " + profesorId);
		}
		
		return theProfesor;
	}
	
	// add mapping for POST /profesores - add new employee
	
	@PostMapping("/profesores")
	public Profesor addProfesor(@RequestBody Profesor theProfesor) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProfesor.setId(0);
		
		profesorService.save(theProfesor);
		
		return theProfesor;
	}
	
	// add mapping for PUT /profesores - update existing profesor
	
	@PutMapping("/profesores")
	public Profesor updateProfesor(@RequestBody Profesor theProfesor) {
		
		profesorService.save(theProfesor);
		
		return theProfesor;
	}
	
	// add mapping for DELETE /profesores/{profesorId} - delete profesor
	@DeleteMapping("/profesores/{profesorId}")
	public String deleteProfesor(@PathVariable int profesorId) {
		
		Profesor tempProfe = profesorService.findById(profesorId);
		
		// throw exception if null
		System.out.println(tempProfe);
		if (tempProfe == null) {
			throw new RuntimeException("Profesor id no encontrado - " + profesorId);
		}
		
		profesorService.deleteById(profesorId);
		
		return "Profesor Eliminado id - " + profesorId;
	}
	
}










