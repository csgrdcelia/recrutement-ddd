package use_case;

import common.dto.CandidatDto;
import common.dto.EntretienDto;
import common.dto.RecruteurDto;
import common.dto.SalleDto;
import infrastructure.exception.AucunRecruteurAdapte;
import infrastructure.exception.AucuneSalleLibre;
import model.*;
import model.repository.Candidats;
import model.repository.Entretiens;
import model.repository.Recruteurs;
import model.repository.Salles;

import java.util.List;

public class PlanifierEntretien {
    private final Candidats candidats;
    private final Entretiens entretiens;
    private final Recruteurs recruteurs;
    private final Salles salles;

    public PlanifierEntretien(Candidats candidats, Entretiens entretiens, Recruteurs recruteurs, Salles salles) {
        this.candidats = candidats;
        this.entretiens = entretiens;
        this.recruteurs = recruteurs;
        this.salles = salles;
    }

    public void planifier(RequetePlanificateur requete) throws AucunRecruteurAdapte, AucuneSalleLibre {
        // Given
        CandidatDto candidat = candidats.getCandidatById(requete.getId());
        List<RecruteurDto> recruteurs = this.recruteurs.findAll();
        List<SalleDto> salles = this.salles.findAll();

        // When
        Entretien entretien = new Entretien(candidat, requete.getDateEntretien());
        entretien.planifier(recruteurs, salles);

        // Then
        entretiens.add(new EntretienDto(entretien));
    }
}