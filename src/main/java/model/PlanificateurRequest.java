package model;

import common.dto.CandidatDto;

import java.time.LocalDateTime;

public class PlanificateurRequest {
    private CandidatDto candidat;
    private LocalDateTime dateEntretien;

    public PlanificateurRequest(CandidatDto candidat, LocalDateTime dateEntretien) {
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
