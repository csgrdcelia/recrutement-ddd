package common.dto;
import model.entretien.CandidatId;

public class CandidatDto {
    private CandidatId candidatId;
    private String nom;
    private String competence;
    private int nbAnneeExperience;

    public CandidatDto(CandidatId candidatId, String nom, String competence, int nbAnneeExperience) {
        this.candidatId = candidatId;
        this.nom = nom;
        this.competence = competence;
        this.nbAnneeExperience = nbAnneeExperience;
    }

    public CandidatId getCandidatId() {
        return candidatId;
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
