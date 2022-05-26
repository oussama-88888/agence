package org.projet.agence.repositories;


import org.projet.agence.models.Serv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Serv, Long> {


    
    
}

