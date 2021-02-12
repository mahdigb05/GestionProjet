package com.ensa.controllers;


import com.ensa.entities.StructureAccueil;
import com.ensa.services.StructureAccueilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.security.RolesAllowed;
import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("gestionProjet/structure/")
public class StructureController {

    @Autowired
    private StructureAccueilService structureAccueilService;

    @PostMapping("/")
    @RolesAllowed({"AGENT","ADMIN"})
    public ResponseEntity<?> ajouterStructure(@RequestBody StructureAccueil structure){
        StructureAccueil structure1 = structureAccueilService.ajouterStructureAccueil(structure);
        return new ResponseEntity(structure1, HttpStatus.CREATED);
    }

    @PutMapping("/")
    @RolesAllowed({"AGENT","ADMIN"})
    public ResponseEntity<?> modifierStructure(@RequestBody StructureAccueil structure){
        StructureAccueil structure1 = structureAccueilService.modifierStructureAccueil(structure);
        return new ResponseEntity(structure1, HttpStatus.OK);
    }

    @DeleteMapping("/{id_structure}")
    @RolesAllowed({"AGENT","ADMIN"})
    public ResponseEntity<?> supprimerStructure(@PathVariable("{id_structure}") Long idStructure){
        structureAccueilService.supprimerStructureAccueil(idStructure);
//        if(structure == null)
//            return new ResponseEntity("la structure n'existe pas",HttpStatus.BAD_REQUEST);
        return new ResponseEntity(" supprimer avec succes",HttpStatus.OK);
    }

    @GetMapping("/")
    @RolesAllowed({"AGENT","ADMIN","ETUDIANT"})
    public Collection<?> listStructure(){
        Collection<StructureAccueil> listeStructures = structureAccueilService.getListStructureAccueil();
        return listeStructures;
    }

    @GetMapping("/{id_structure}")
    @RolesAllowed({"AGENT","ADMIN"})
    public ResponseEntity<?> getStructure(@PathVariable("{id_structure}") Long idStructure){
        StructureAccueil structure = structureAccueilService.getStructureAccueil(idStructure);
        if(structure == null)
            return new ResponseEntity<>("la structure n'existe pas",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(structure,HttpStatus.OK);
    }

}
