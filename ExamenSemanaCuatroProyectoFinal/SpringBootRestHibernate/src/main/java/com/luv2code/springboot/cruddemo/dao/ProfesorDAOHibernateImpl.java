package com.luv2code.springboot.cruddemo.dao;

import java.util.List;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Profesor;

@Repository
public class ProfesorDAOHibernateImpl implements ProfesorDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public ProfesorDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Profesor> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Profesor> theQuery =
				currentSession.createQuery("from Profesor", Profesor.class);
		
		// execute query and get result list
		List<Profesor> profesores = theQuery.getResultList();
		
		// return the results		
		return profesores;
	}


	@Override
	public Profesor findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the profesor
		Profesor theProfesor =
				currentSession.get(Profesor.class, theId);
		
		// return the profesor
		return theProfesor;
	}


	@Override
	public void save(Profesor theProfesor) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save profesor
		currentSession.saveOrUpdate(theProfesor);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Profesor where id=:profesorId");
		theQuery.setParameter("profesorId", theId);
		
		theQuery.executeUpdate();
	}

}







