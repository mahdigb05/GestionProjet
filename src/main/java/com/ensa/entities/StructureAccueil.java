package com.ensa.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class StructureAccueil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStructure;
    private String adresse;
    private String description;
    private String email;
    private String nomStructure;
    private String tel;
    @OneToMany(mappedBy = "structureAccueil")
    private List<Rapport> rapport;

    public StructureAccueil(Long idStructure, String adresse, String description, String email, String nomStructure, String tel) {
        this.idStructure = idStructure;
        this.adresse = adresse;
        this.description = description;
        this.email = email;
        this.nomStructure = nomStructure;
        this.tel = tel;
    }

    public StructureAccueil() {
    }

    public Long getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(Long idStructure) {
        this.idStructure = idStructure;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomStructure() {
        return nomStructure;
    }

    public void setNomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Rapport> getRapport() {
        return rapport;
    }

    public void setRapport(List<Rapport> rapport) {
        this.rapport = rapport;
    }
}
