package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Rapport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRapport;
    @Column
    private String sujet;
    @Column
    private Date dateDepot;
    @Column
    private boolean archive;
    @Column
    private Date dateArchivage;
    @Column
    private String cheminDocument;
    @Column
    private String filiere;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private StructureAccueil structureAccueil;
    @ManyToMany
    @JoinTable(
            name="rapport_jury",
            joinColumns = @JoinColumn(name = "idRapport"),
            inverseJoinColumns = @JoinColumn(name="idMembreJury")
    )
    private List<MembreJury> jury;

    public Rapport() {
    }

    public Rapport(Long idRapport, String sujet, Date dateDepot, boolean archive, Date dateArchivage, String cheminDocument, String filiere) {
        this.idRapport = idRapport;
        this.sujet = sujet;
        this.dateDepot = dateDepot;
        this.archive = archive;
        this.dateArchivage = dateArchivage;
        this.cheminDocument = cheminDocument;
        this.filiere = filiere;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public Date getDateArchivage() {
        return dateArchivage;
    }

    public void setDateArchivage(Date dateArchivage) {
        this.dateArchivage = dateArchivage;
    }

    public String getCheminDocument() {
        return cheminDocument;
    }

    public void setCheminDocument(String cheminDocument) {
        this.cheminDocument = cheminDocument;
    }

    public Long getIdRapport() {
        return idRapport;
    }

    public void setIdRapport(Long idRapport) {
        this.idRapport = idRapport;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public List<MembreJury> getJury() {
        return jury;
    }

    public void setJury(List<MembreJury> jury) {
        this.jury = jury;
    }
}
