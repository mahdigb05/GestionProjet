package com.ensa.repositories;


import com.ensa.entities.StructureAccueil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructureAccueilRepo extends CrudRepository<StructureAccueil,Long> {
}
