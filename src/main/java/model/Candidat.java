package model;

import java.util.UUID;

public class Candidat {
    private String id;
    private String nom;
    private String competence;
    private int nbAnneeExperience;

    public Candidat(String nom, String competence, int nbAnneeExperience) {
        this.id = UUID.randomUUID().toString();
        this.nom = nom;
        this.competence = competence;
        this.nbAnneeExperience = nbAnneeExperience;
    }

    public String getId() {
        return id;
    }

    public String getCompetence() {
        return competence;
    }

    public int getNbAnneeExperience() {
        return nbAnneeExperience;
    }
}