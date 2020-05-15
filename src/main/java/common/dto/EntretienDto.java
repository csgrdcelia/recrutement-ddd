package common.dto;

import model.entretien.Entretien;
import model.entretien.EntretienId;

import java.time.LocalDateTime;

public class EntretienDto {
    private EntretienId id;
    private CandidatDto candidat;
    private RecruteurDto recruteur;
    private SalleDto salle;
    private LocalDateTime dateEntretien;

    public EntretienDto(EntretienId id, CandidatDto candidat, RecruteurDto recruteur, SalleDto salle, LocalDateTime dateEntretien) {
        this.id = id;
        this.candidat = candidat;
        this.recruteur = recruteur;
        this.salle = salle;
        this.dateEntretien = dateEntretien;
    }

    public EntretienDto(Entretien entretien) {
        this.id = entretien.getEntretienId();
        this.candidat = entretien.getCandidat();
        this.recruteur = entretien.getRecruteur();
        this.salle = entretien.getSalle();
        this.dateEntretien = entretien.getDateEntretien();
    }

    public CandidatDto getCandidat() {
        return candidat;
    }

    public RecruteurDto getRecruteur() {
        return recruteur;
    }

    public SalleDto getSalle() {
        return salle;
    }
}
