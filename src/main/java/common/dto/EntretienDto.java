package common.dto;

import model.Entretien;
import model.Salle;

import java.time.LocalDateTime;

public class EntretienDto {
    private String id;
    private CandidatDto candidat;
    private RecruteurDto recruteur;
    private SalleDto salle;
    private LocalDateTime dateEntretien;

    public EntretienDto(String id, CandidatDto candidat, RecruteurDto recruteur, SalleDto salle, LocalDateTime dateEntretien) {
        this.id = id;
        this.candidat = candidat;
        this.recruteur = recruteur;
        this.salle = salle;
        this.dateEntretien = dateEntretien;
    }

    public EntretienDto(Entretien entretien) {
        this.id = entretien.getId();
        this.candidat = entretien.getCandidat();
        this.recruteur = entretien.getRecruteur();
        this.salle = entretien.getSalle();
        this.dateEntretien = entretien.getDateEntretien();
    }
}
