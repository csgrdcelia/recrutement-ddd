package common.dto;

import model.Recruteur;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RecruteurDto {
    private String id;
    private List<LocalDateTime> disponibilites;
    private String competence;
    private int nbAnneeExperience;

    public RecruteurDto(List<LocalDateTime> disponibilites, String competence, int nbAnneeExperience) {
        this.id = UUID.randomUUID().toString();
        this.disponibilites = disponibilites;
        this.competence = competence;
        this.nbAnneeExperience = nbAnneeExperience;
    }

    public RecruteurDto(Recruteur recruteur) {
        this.id = recruteur.getId();
        this.disponibilites = recruteur.getDisponibilites();
        this.competence = recruteur.getCompetence();
        this.nbAnneeExperience = recruteur.getNbAnneeExperience();
    }

    public String getId() {
        return id;
    }

    public List<LocalDateTime> getDisponibilites() {
        return disponibilites;
    }

    public String getCompetence() {
        return competence;
    }

    public int getNbAnneeExperience() {
        return nbAnneeExperience;
    }
}