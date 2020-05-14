package model;

import java.time.LocalDateTime;
import java.util.List;

public class Recruteur {
    private List<LocalDateTime> disponibilites;
    private String competence;
    private int nbAnneeExperience;

    public Recruteur() {
    }

    public Recruteur(List<LocalDateTime> disponibilites, String competence) {
        this.disponibilites = disponibilites;
        this.competence = competence;
    }

    public List<LocalDateTime> getDisponibilites() {
        return disponibilites;
    }

    public String getCompetence() {
        return competence;
    }

    public boolean estDisponible(LocalDateTime date) {
        return disponibilites.contains(date);
    }

    public int getNbAnneeExperience() {
        return nbAnneeExperience;
    }
}
