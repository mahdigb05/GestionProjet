package com.ensa.services;


import com.ensa.entities.MembreJury;
import com.ensa.repositories.MembreJuryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
public class MembreJuryService {

    @Autowired
    private MembreJuryRepo membreJuryRepo;

    public MembreJury getMembreJury(Long id){
        return membreJuryRepo.findById(id).orElse(null);
    }

    public List<MembreJury> getAllMembreJury(){
        return (List<MembreJury>) membreJuryRepo.findAll();
    }

}
