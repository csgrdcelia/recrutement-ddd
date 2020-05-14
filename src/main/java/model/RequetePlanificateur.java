package model;

import java.time.LocalDateTime;

public class RequetePlanificateur {
    private String id;
    private LocalDateTime dateEntretien;

    public RequetePlanificateur(String candidatId, LocalDateTime dateEntretien) {
        this.id = candidatId;
        this.dateEntretien = dateEntretien;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDateEntretien() {
        return dateEntretien;
    }
}
