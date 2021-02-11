package com.ensa.controllers;

import com.ensa.entities.Utilisateur;
import com.ensa.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("gestionProjet/utilisateur")
@CrossOrigin(origins = "http://localhost:3000")
public class UtilisateurContoller {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/")
    @RolesAllowed({"AGENT","ADMIN"})
    public ResponseEntity<?> ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        Utilisateur utilisateur1 = utilisateurService.ajouterUtilisateur(utilisateur);
        return new ResponseEntity(utilisateur1, HttpStatus.CREATED);
    }

    @PutMapping("/")
    @RolesAllowed({"AGENT","ADMIN"})
    public ResponseEntity<?> modifierUtilisateur(@RequestBody Utilisateur utilisateur){
        Utilisateur utilisateur1 = utilisateurService.modifierUtilisateur(utilisateur);
        return new ResponseEntity(utilisateur1, HttpStatus.OK);
    }

    @DeleteMapping("/{id_utilisateur}")
    @RolesAllowed({"AGENT","ADMIN"})
    public ResponseEntity<?> supprimerUtilisateur(@PathVariable("{id_utilisateur}") Long idUtilisateur){
        Utilisateur utilisateur = utilisateurService.supprimerUtilisateur(idUtilisateur);
        if(utilisateur == null)
            return new ResponseEntity("l'utilisateur n'existe pas",HttpStatus.BAD_REQUEST);
        return new ResponseEntity(utilisateur,HttpStatus.OK);
    }

    @GetMapping("/")
    @RolesAllowed({"AGENT","ADMIN"})
    public ResponseEntity<?> listUtilisateur(){
        return new ResponseEntity<>(utilisateurService.getListUtilisateur(),HttpStatus.OK);
    }

    @GetMapping("/{id_utilisateur}")
    @RolesAllowed({"AGENT","ADMIN"})
    public ResponseEntity<?> getUtilisateur(@PathVariable("{id_utilisateur}") Long idUtilisateur){
        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUtilisateur);
        if(utilisateur == null)
            return new ResponseEntity<>("l'utilisateur n'existe pas",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(utilisateur,HttpStatus.OK);
    }

}
