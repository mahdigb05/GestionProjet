package com.ensa.services;


import com.ensa.entities.Utilisateur;
import com.ensa.exceptions.EmailExisteDejaException;
import com.ensa.exceptions.UtilisateurNonExistantException;
import com.ensa.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UtilisateurService {


    @Autowired
    private UtilisateurRepo utilisateurRepo;

    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur){
        if(utilisateurRepo.findByEmail(utilisateur.getEmail()) != null)
            throw new EmailExisteDejaException("un utilisateur avec le meme email existe deja");
        utilisateurRepo.save(utilisateur);
        return utilisateur;
    }

    public Utilisateur modifierUtilisateur(Utilisateur utilisateur){
        if(utilisateurRepo.existsById(utilisateur.getId()) != true)
            throw new UtilisateurNonExistantException("l'utilisateur a modifier n'existe pas");
        else if(utilisateurRepo.findByEmail(utilisateur.getEmail()) != null)
            throw new EmailExisteDejaException("un utilisateur avec le meme email existe deja");
        utilisateurRepo.save(utilisateur);
        return utilisateur;
    }

    public void supprimerUtilisateur(Long code){
        //Utilisateur utilisateur = utilisateurRepo.findById(code).orElse(null);
        utilisateurRepo.deleteById(code);
    }

    public List<Utilisateur> getListUtilisateur(){
        return (List<Utilisateur>) utilisateurRepo.findAll();
    }

    public Utilisateur getUtilisateur(Long id_Utilisateur){
        return  utilisateurRepo.findById(id_Utilisateur).orElse(null);
    }

}
