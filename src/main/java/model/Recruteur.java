package model;

import common.dto.CandidatDto;

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

    public boolean peutTesterCandidat(CandidatDto candidat, LocalDateTime dateEntretien) {
        return this.estDisponible(dateEntretien) &&
                this.getCompetence().equals(candidat.getCompetence()) &&
                this.getNbAnneeExperience() > candidat.getNbAnneeExperience();
    }
}
