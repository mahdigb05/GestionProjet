package services;

import exceptions.NonExistanteInstanceException;
import entities.StructureAccueil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.StructureAccueilRepo;

import java.util.List;

@Service
public class StructureAccueilService {

    @Autowired
    private StructureAccueilRepo structureAccueilRepo;

    public StructureAccueil ajouterStructureAccueil(StructureAccueil structure){
        structureAccueilRepo.save(structure);
        return structure;
    }

    public StructureAccueil modifierStructureAccueil(StructureAccueil structureAccueil){
        if(!structureAccueilRepo.existsById(structureAccueil.getIdStructure()))
            throw new NonExistanteInstanceException("la strcture a modifier n'exste pas");
        structureAccueilRepo.save(structureAccueil);
        return structureAccueil;
    }

    public StructureAccueil supprimerStructureAccueil(Long code){
        StructureAccueil structure = structureAccueilRepo.findById(code).orElse(null);
        if(structure != null){
            structureAccueilRepo.delete(structure);
            return structure;
        }
        return null;
    }

    public List<StructureAccueil> getListStructureAccueil(){
        return (List<StructureAccueil>) structureAccueilRepo.findAll();
    }

    public StructureAccueil getStructureAccueil(Long id_StructureAccueil){
        return structureAccueilRepo.findById(id_StructureAccueil).orElse(null);
    }
}
