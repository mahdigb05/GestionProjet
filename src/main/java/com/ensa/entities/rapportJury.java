package com.ensa.entities;

import javax.persistence.*;

@Entity
public class rapportJury {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rapport_jury;


    @ManyToOne
    @JoinColumn(name = "id_membre_jury")
    private MembreJury membreJury;

    @ManyToOne
    @JoinColumn(name = "id_rapport")
    private Rapport rapport;

    public rapportJury() {
    }

    public rapportJury(Long id_rapport_jury, MembreJury membreJury, Rapport rapport) {
        this.id_rapport_jury = id_rapport_jury;
        this.membreJury = membreJury;
        this.rapport = rapport;
    }

    public Long getId_rapport_jury() {
        return id_rapport_jury;
    }

    public void setId_rapport_jury(Long id_rapport_jury) {
        this.id_rapport_jury = id_rapport_jury;
    }

    public MembreJury getMembreJury() {
        return membreJury;
    }

    public void setMembreJury(MembreJury membreJury) {
        this.membreJury = membreJury;
    }

    public Rapport getRapport() {
        return rapport;
    }

    public void setRapport(Rapport rapport) {
        this.rapport = rapport;
    }
}
