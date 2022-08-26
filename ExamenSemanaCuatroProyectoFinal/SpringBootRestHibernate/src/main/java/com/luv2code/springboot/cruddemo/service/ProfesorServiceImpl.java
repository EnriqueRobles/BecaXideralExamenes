package com.luv2code.springboot.cruddemo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.ProfesorDAO;
import com.luv2code.springboot.cruddemo.entity.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	private ProfesorDAO profesorDAO;
	
	/*@Autowired
	public ProfesorServiceImpl(ProfesorDAO theProfesorDAO) {
		profesorDAO = theProfesorDAO;
	}*/
	
	@Autowired
	public ProfesorServiceImpl(@Qualifier("profesorDAOJDBC") ProfesorDAO theProfesorDAO) {
		profesorDAO = theProfesorDAO;
	}
	
	@Override
	@Transactional
	public List<Profesor> findAll() {
		return profesorDAO.findAll();
	}

	@Override
	@Transactional
	public Profesor findById(int theId) {
		return profesorDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Profesor theProfesor) {
		profesorDAO.save(theProfesor);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		profesorDAO.deleteById(theId);
	}

}






