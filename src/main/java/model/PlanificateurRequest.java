package model;

import java.time.LocalDateTime;

public class PlanificateurRequest {
    private Candidat candidat;
    private LocalDateTime dateEntretien;

    public PlanificateurRequest(Candidat candidat, LocalDateTime dateEntretien) {
        this.candidat = candidat;
        this.dateEntretien = dateEntretien;
    }

    public String getCandidatId() {
        return candidat.getId();
    }

    public LocalDateTime getDateEntretien() {
        return dateEntretien;
    }
}
