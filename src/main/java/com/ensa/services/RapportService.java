package com.ensa.services;


import com.ensa.Utils.UtilMethodes;
import com.ensa.entities.Rapport;
import com.ensa.entities.StructureAccueil;
import com.ensa.entities.Utilisateur;
import com.ensa.exceptions.NonExistanteInstanceException;
import com.ensa.repositories.RapportRepo;
import com.ensa.repositories.StructureAccueilRepo;
import com.ensa.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class RapportService {

    @Autowired
    private RapportRepo rapportRepo;
    @Autowired
    private UtilisateurRepo utilisateurRepo;
    @Autowired
    private StructureAccueilRepo structureAccueilRepo;

    public Rapport ajouterRapport(MultipartFile file,Long idStructure, String email, String filiere, String sujet){

        Rapport rapport = new Rapport();
        rapport.setFiliere(filiere);
        rapport.setSujet(sujet);

        String path = UtilMethodes.sauvegarderFichier(file);
        rapport.setCheminDocument(path);

        Utilisateur utilisateur = utilisateurRepo.findByEmail(email);
        StructureAccueil structureAccueil = structureAccueilRepo.findById(idStructure).orElse(null);

        rapport.setStructureAccueil(structureAccueil);
        rapport.setUtilisateur(utilisateur);
        rapport.setDateDepot(new Date(System.currentTimeMillis()));
        rapportRepo.save(rapport);
        return rapport;
    }

//    public Rapport modifierRapport(MultipartFile file,Long idStructure, String email, String filiere, String sujet, Long idRapport){
//
//        Rapport rapport = rapportRepo.findById(idRapport).orElse(null);
//        rapport.setFiliere(filiere);
//        rapport.setSujet(sujet);
//        if(file != null){
//            String path = UtilMethodes.sauvegarderFichier(file);
//            rapport.setCheminDocument(path);
//        }
//        Utilisateur utilisateur = utilisateurRepo.findByEmail(email);
//        StructureAccueil structureAccueil = structureAccueilRepo.findById(idStructure).orElse(null);
//        rapport.setStructureAccueil(structureAccueil);
//        rapport.setUtilisateur(utilisateur);
//        rapportRepo.save(rapport);
//        return rapport;
//    }

    public Rapport modifierRapport(Rapport rapport){
        return rapportRepo.save(rapport);
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

    public Rapport archiverRapport(Long idRapport){
        Rapport rapport = rapportRepo.findById(idRapport).orElse(null);
        rapport.setArchive(true);
        rapport.setDateArchivage(new Date(System.currentTimeMillis()));
        rapportRepo.save(rapport);
        return rapport;
    }

}
