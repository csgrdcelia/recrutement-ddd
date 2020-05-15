package model.entretien;

import java.time.LocalDateTime;

public class RequetePlanificateur {
    private CandidatId id;
    private LocalDateTime dateEntretien;

    public RequetePlanificateur(CandidatId candidatId, LocalDateTime dateEntretien) {
        this.id = candidatId;
        this.dateEntretien = dateEntretien;
    }

    public CandidatId getCandidatId() {
        return id;
    }

    public LocalDateTime getDateEntretien() {
        return dateEntretien;
    }
}
