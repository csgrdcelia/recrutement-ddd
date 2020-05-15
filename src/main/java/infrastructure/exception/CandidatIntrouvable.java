package infrastructure.exception;
import model.entretien.CandidatId;

public class CandidatIntrouvable extends Exception {
    public CandidatIntrouvable(CandidatId candidatId) {
        super("Le candidat portant l'id " + candidatId.getId() + " est introuvable.");
    }
}
