package services;

import exceptions.EmailExisteDejaException;
import exceptions.UtilisateurNonExistantException;
import entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UtilisateurRepo;

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

    public Utilisateur supprimerUtilisateur(Long code){
        Utilisateur utilisateur = utilisateurRepo.findById(code).orElse(null);
        if(utilisateur != null){
            utilisateurRepo.delete(utilisateur);
            return utilisateur;
        }
        return null;
    }

    public List<Utilisateur> getListUtilisateur(){
        return (List<Utilisateur>) utilisateurRepo.findAll();
    }

    public Utilisateur getUtilisateur(Long id_Utilisateur){
        return  utilisateurRepo.findById(id_Utilisateur).orElse(null);
    }

}
