package model.entretien;

import common.dto.CandidatDto;
import common.dto.RecruteurDto;
import infrastructure.exception.RecruteurIndisponible;

import java.time.LocalDateTime;
import java.util.List;

public class Recruteur {
    private RecruteurId recruteurId;
    private List<LocalDateTime> disponibilites;
    private String competence;
    private int nbAnneeExperience;

    public Recruteur(RecruteurId recruteurId, List<LocalDateTime> disponibilites, String competence, int nbAnneeExperience) {
        this.recruteurId = recruteurId;
        this.disponibilites = disponibilites;
        this.competence = competence;
        this.nbAnneeExperience = nbAnneeExperience;
    }

    public Recruteur(RecruteurDto recruteurDto) {
        this.recruteurId = recruteurDto.getRecruteurId();
        this.disponibilites = recruteurDto.getDisponibilites();
        this.competence = recruteurDto.getCompetence();
        this.nbAnneeExperience = recruteurDto.getNbAnneeExperience();
    }

    public boolean peutTesterCandidat(CandidatDto candidat, LocalDateTime dateEntretien) {
        return this.estDisponible(dateEntretien) &&
                this.getCompetence().equals(candidat.getCompetence()) &&
                this.getNbAnneeExperience() > candidat.getNbAnneeExperience();
    }

    public void reserver(LocalDateTime dateEntretien) throws RecruteurIndisponible {
        if (!estDisponible(dateEntretien))
            throw new RecruteurIndisponible(dateEntretien);
        disponibilites.remove(dateEntretien);
    }

    public boolean estDisponible(LocalDateTime dateEntretien) {
        return this.disponibilites.stream().filter(disponibilite -> disponibilite.equals(dateEntretien)).count() == 1;
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
