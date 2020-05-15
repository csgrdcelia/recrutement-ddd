package common.dto;

import model.entretien.Recruteur;
import model.entretien.RecruteurId;
import java.time.LocalDateTime;
import java.util.List;

public class RecruteurDto {
    private RecruteurId recruteurId;
    private List<LocalDateTime> disponibilites;
    private String competence;
    private int nbAnneeExperience;

    public RecruteurDto(RecruteurId recruteurId, List<LocalDateTime> disponibilites, String competence, int nbAnneeExperience) {
        this.recruteurId = recruteurId;
        this.disponibilites = disponibilites;
        this.competence = competence;
        this.nbAnneeExperience = nbAnneeExperience;
    }

    public RecruteurDto(Recruteur recruteur) {
        this.recruteurId = recruteur.getRecruteurId();
        this.disponibilites = recruteur.getDisponibilites();
        this.competence = recruteur.getCompetence();
        this.nbAnneeExperience = recruteur.getNbAnneeExperience();
    }

    public RecruteurId getRecruteurId() {
        return recruteurId;
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