package controllers;

import entities.Rapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.RapportService;

import javax.annotation.security.RolesAllowed;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("gestionProjet/rapport")
public class RapportController {

    @Autowired
    private RapportService rapportService;

    @PostMapping("/")
    @RolesAllowed({"ETUDIANT"})
    public ResponseEntity<?> ajouterRapport(@RequestBody Rapport rapport){
        Rapport rapport1 = rapportService.ajouterRapport(rapport);
        return new ResponseEntity(rapport1,HttpStatus.CREATED);
    }

    @PutMapping("/")
    @RolesAllowed({"ETUDIANT","AGENT","ADMIN"})
    public ResponseEntity<?> modifierRapport(@RequestBody Rapport rapport){
        Rapport rapport1 = rapportService.modifierRapport(rapport);
        return new ResponseEntity(rapport1,HttpStatus.OK);
    }

    @DeleteMapping("/{id_rapport}")
    @RolesAllowed({"ETUDIANT","AGENT","ADMIN"})
    public ResponseEntity<?> supprimerRapport(@PathVariable("{id_rapport}") Long idRapport){
        Rapport rapport = rapportService.supprimerRapport(idRapport);
        if(rapport == null)
            return new ResponseEntity("le rapport n'existe pas",HttpStatus.BAD_REQUEST);
        return new ResponseEntity(rapport,HttpStatus.OK);
    }

    @GetMapping("/")
    @RolesAllowed({"ETUDIANT","AGENT","ADMIN"})
    public ResponseEntity<?> listRapport(){
        return new ResponseEntity<>(rapportService.getListRapport(),HttpStatus.OK);
    }

    @GetMapping("/{id_rapport}")
    @RolesAllowed({"ETUDIANT","AGENT","ADMIN"})
    public ResponseEntity<?> getRapport(@PathVariable("{id_rapport}") Long idRapport){
        Rapport rapport = rapportService.getRapport(idRapport);
        if(rapport == null)
            return new ResponseEntity<>("le rapport n'existe pas",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(rapport,HttpStatus.OK);
    }


//    @PostMapping("/{id_rapport}/jury")
//    public ResponseEntity<?> affecterJury(@RequestBody List<Long> jury, @PathParam("id_rapport") Long idRapport){
//
//    }

    @GetMapping(value = "/{id_rapport}", params = "archive")
    public ResponseEntity<?> getRapportArchiver(){
        return new ResponseEntity<>(rapportService.getListRapportArchive(),HttpStatus.OK);
    }

}
