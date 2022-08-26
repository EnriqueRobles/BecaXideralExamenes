package com.luv2code.springboot.cruddemo.dao;

import java.util.List;


import com.luv2code.springboot.cruddemo.entity.Profesor;

public interface ProfesorDAO {

	public List<Profesor> findAll();
	
	public Profesor findById(int theId);
	
	public void save(Profesor theProfesor);
	
	public void deleteById(int theId);
	
}
