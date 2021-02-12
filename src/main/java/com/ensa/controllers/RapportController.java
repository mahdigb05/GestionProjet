package com.ensa.controllers;


import com.ensa.entities.Rapport;
import com.ensa.services.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.security.RolesAllowed;
import java.util.Collection;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RapportController {

    @Autowired
    private RapportService rapportService;

    @PostMapping("/rapport")
    @RolesAllowed({"ETUDIANT"})
    public ResponseEntity<?> ajouterRapport(@RequestParam("file") MultipartFile file,
                                            @RequestParam("idStructure") Long idStructure,
                                            @RequestParam("email") String email,
                                            @RequestParam ("filiere") String filier,
                                            @RequestParam ("sujet") String sujet){
        Rapport rapport1 = rapportService.ajouterRapport(file,idStructure,email,filier,sujet);
        return new ResponseEntity(rapport1,HttpStatus.CREATED);
    }

    @PutMapping("/rapport")
    @RolesAllowed({"ETUDIANT","AGENT","ADMIN"})
//    public ResponseEntity<?> modifierRapport(@RequestParam(value = "file", required = false) MultipartFile file,
//                                             @RequestParam("idStructure") Long idStructure,
//                                             @RequestParam("email") String email,
//                                             @RequestParam ("filiere") String filier,
//                                             @RequestParam ("sujet") String sujet,
//                                             @RequestParam ("idRapport") Long idRapport){
//        Rapport rapport1 = rapportService.modifierRapport(file,idStructure,email,filier,sujet,idRapport);
//        return new ResponseEntity(rapport1,HttpStatus.OK);
//    }
    public ResponseEntity<?> modifierRapport(@RequestBody Rapport rapport){
        rapportService.modifierRapport(rapport);
        return new ResponseEntity(rapport,HttpStatus.OK);
    }

    @DeleteMapping("/rapport/{id_rapport}")
    @RolesAllowed({"ETUDIANT","AGENT","ADMIN"})
    public ResponseEntity<?> supprimerRapport(@PathVariable("id_rapport") Long idRapport){

        Rapport rapport = rapportService.supprimerRapport(idRapport);
        return new ResponseEntity("rapport supprimer avec succes",HttpStatus.OK);
    }

    @GetMapping("/rapport")
    @RolesAllowed({"ETUDIANT","AGENT","ADMIN"})
    public Collection<?> listRapport(){
        return rapportService.getListRapport();
    }

    @GetMapping("/rapport/{id_rapport}")
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

    @GetMapping(value = "/rapport/", params = "archive")
    public ResponseEntity<?> getRapportArchiver(){
        return new ResponseEntity<>(rapportService.getListRapportArchive(),HttpStatus.OK);
    }

    @PostMapping(value = "/rapport/{idRapport}", params = "archiver")
    @RolesAllowed({"AGENT"})
    public ResponseEntity<?> archiverRapport(@PathVariable("idRapport") Long idRapport){
        Rapport rapport = rapportService.archiverRapport(idRapport);
        return new ResponseEntity<>(rapport,HttpStatus.OK);
    }

}
