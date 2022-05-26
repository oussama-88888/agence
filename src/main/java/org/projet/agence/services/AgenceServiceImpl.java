package org.projet.agence.services;

import java.util.List;

import org.projet.agence.models.Agence;
import org.projet.agence.models.Serv;
import org.projet.agence.repositories.AgenceRepository;
import org.projet.agence.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AgenceServiceImpl implements AgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private ServiceRepository serviceRepository;
    


    @Override
    public Agence saveAgence(Agence l) {

        return agenceRepository.save(l);
    }

    @Override
    public Agence updateAgence(Agence l) {

        return agenceRepository.save(l);
    }

    @Override
    public void deleteAgence(Agence l) {

        agenceRepository.delete(l);
        
    }

    @Override
    public void deleteAgenceById(Long id) {
         agenceRepository.deleteById(id);
        
    }

    @Override
    public Agence getAgence(Long id) {

        return agenceRepository.findById(id).get();
    }

    @Override
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Page<Agence> getAllAgencesParPage(int page, int size) {

        return agenceRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Serv saveService(Serv s) {
        return serviceRepository.save(s);
       
    }

    @Override
    public Serv updateService(Serv s) {
        return serviceRepository.save(s);
    }

    @Override
    public void deleteServiceById(Long id) {
        serviceRepository.deleteById(id);
        
    }

    @Override
    public List<Serv> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Serv getService(Long id) {
        return serviceRepository.findById(id).get();
    }

    


  

    
}
