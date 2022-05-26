package org.projet.agence.repositories;

import org.projet.agence.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "rest")
@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {


    
    
}
