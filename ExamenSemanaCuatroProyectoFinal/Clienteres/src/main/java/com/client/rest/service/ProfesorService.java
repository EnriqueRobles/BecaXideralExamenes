package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Profesor;

public interface ProfesorService {

	public List<Profesor> getProfesor();

	public void saveProfesor(Profesor theProfesor);

	public Profesor getProfesor(int theId);

	public void deleteProfesor(int theId);
	
}
