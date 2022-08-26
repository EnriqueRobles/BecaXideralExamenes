package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Profesor;

public interface ProfesorService {

	public List<Profesor> findAll();
	
	public Profesor findById(int theId);
	
	public void save(Profesor theProfesor);
	
	public void deleteById(int theId);
	
}
