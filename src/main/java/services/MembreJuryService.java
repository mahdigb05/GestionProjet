package services;

import entities.MembreJury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.MembreJuryRepo;

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
