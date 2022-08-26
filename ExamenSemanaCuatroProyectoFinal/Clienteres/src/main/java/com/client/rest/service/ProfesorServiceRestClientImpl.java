package com.client.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.rest.model.Profesor;

@Service
public class ProfesorServiceRestClientImpl implements ProfesorService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public ProfesorServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Profesor> getProfesor() {
		
		logger.info("***OBTENER LISTA DE PROFESORES DESDE EL SERVICE REST CLIENTE");
		logger.info("in getProfesor(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Profesor>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Profesor>>() {});

		// get the list of profesor from response
		List<Profesor> profesor = responseEntity.getBody();

		logger.info("in getProfesor(): profesor" + profesor);
		
		return profesor;
	}

	@Override
	public Profesor getProfesor(int theId) {
		logger.info("***OBTENER UN PROFESOR DESDE EL SERVICE REST CLIENTE");

		logger.info("in getProfesor(): Calling REST API " + crmRestUrl);

		// make REST call
		Profesor theProfesor = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Profesor.class);

		logger.info("in saveProfesor(): theProfesor=" + theProfesor);
		
		return theProfesor;
	}

	@Override
	public void saveProfesor(Profesor theProfesor) {

		logger.info("in saveProfesor(): Calling REST API " + crmRestUrl);
		
		int employeeId = theProfesor.getId();

		// make REST call
		if (employeeId == 0) {
			// add employee
			logger.info("***SALVAR UN Profesor DESDE EL SERVICE REST CLIENTE");

			restTemplate.postForEntity(crmRestUrl, theProfesor, String.class);			
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UN PROFESOR DESDE EL SERVICE REST CLIENTE");

			restTemplate.put(crmRestUrl, theProfesor);
		}

		logger.info("in saveProfesor(): success");	
	}

	@Override
	public void deleteProfesor(int theId) {
		logger.info("***BORRAR UN PROFESOR DESDE EL SERVICE REST CLIENTE");

		logger.info("in deleteProfesor(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteProfesor(): deleted Profesor theId=" + theId);
	}

}
