package model;

import common.dto.CandidatDto;
import common.dto.RecruteurDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Recruteur {
    private String id;
    private List<LocalDateTime> disponibilites;
    private String competence;
    private int nbAnneeExperience;

    public Recruteur(List<LocalDateTime> disponibilites, String competence, int nbAnneeExperience) {
        this.id = UUID.randomUUID().toString();
        this.disponibilites = disponibilites;
        this.competence = competence;
        this.nbAnneeExperience = nbAnneeExperience;
    }

    public Recruteur(RecruteurDto recruteurDto) {
        this.id = recruteurDto.getId();
        this.disponibilites = recruteurDto.getDisponibilites();
        this.competence = recruteurDto.getCompetence();
        this.nbAnneeExperience = recruteurDto.getNbAnneeExperience();
    }

    public boolean peutTesterCandidat(CandidatDto candidat, LocalDateTime dateEntretien) {
        return this.estDisponible(dateEntretien) &&
                this.getCompetence().equals(candidat.getCompetence()) &&
                this.getNbAnneeExperience() > candidat.getNbAnneeExperience();
    }

    public void reserver(LocalDateTime dateEntretien) {
        //TODO: remove disponibility
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

    public boolean estDisponible(LocalDateTime dateEntretien) {
        return this.getDisponibilites().stream().filter(disponibilite -> disponibilite.equals(dateEntretien)).count() == 1;
    }

    public int getNbAnneeExperience() {
        return nbAnneeExperience;
    }


}
