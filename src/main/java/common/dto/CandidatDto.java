package common.dto;

import java.util.UUID;

public class CandidatDto {
    private String id;
    private String nom;
    private String competence;
    private int nbAnneeExperience;

    public CandidatDto(String id, String nom, String competence, int nbAnneeExperience) {
        this.id = id;
        this.nom = nom;
        this.competence = competence;
        this.nbAnneeExperience = nbAnneeExperience;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCompetence() {
        return competence;
    }

    public int getNbAnneeExperience() {
        return nbAnneeExperience;
    }
}
