package model;

import java.util.UUID;

public class Candidat {
    private String id;
    private String nom;
    private String competence;
    private int nbAnneeExperience;

    public Candidat(String nom, String competence) {
        this.id = UUID.randomUUID().toString();
        this.nom = nom;
        this.competence = competence;
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