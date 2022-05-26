package org.projet.agence.services;

import java.util.List;

import org.projet.agence.models.Agence;
import org.projet.agence.models.Serv;
import org.springframework.data.domain.Page;

public interface AgenceService {
    
	Serv saveService(Serv s);
	Serv updateService(Serv s);
	void deleteServiceById(Long id);
	Serv getService(Long id);
	List<Serv>getAllServices();

	
    Agence saveAgence(Agence l);
	Agence updateAgence(Agence l);
	void deleteAgence(Agence l);
	void deleteAgenceById(Long id);
	Agence getAgence(Long id);
	List<Agence>getAllAgences();

    Page<Agence> getAllAgencesParPage(int page, int size);

}
