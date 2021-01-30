package services;

import exceptions.NonExistanteInstanceException;
import entities.Rapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RapportRepo;

import java.util.List;
import java.util.Optional;

@Service
public class RapportService {

    @Autowired
    private RapportRepo rapportRepo;

    public Rapport ajouterRapport(Rapport rapport){
        rapportRepo.save(rapport);
        return rapport;
    }

    public Rapport modifierRapport(Rapport rapport){
        if(!rapportRepo.existsById(rapport.getIdRapport()))
            throw new NonExistanteInstanceException("le rapport a modifier n'exste pas");
        rapportRepo.save(rapport);
        return rapport;
    }

    public Rapport supprimerRapport(Long code){
        Optional<Rapport> rapport = rapportRepo.findById(code);
        if(rapport.isPresent()) {
            rapportRepo.deleteById(code);
            return rapport.get();
        }
        return null;
    }

    public List<Rapport> getListRapport(){
        return (List<Rapport>) rapportRepo.findAll();
    }

    public List<Rapport> getListRapportArchive(){ return (List<Rapport>) rapportRepo.findRapportByArchive(); }

    public Rapport getRapport(Long id_Rapport){
        return rapportRepo.findById(id_Rapport).orElse(null);
    }

}
