package use_case.entretien;

import common.dto.CandidatDto;
import common.dto.EntretienDto;
import common.dto.RecruteurDto;
import common.dto.SalleDto;
import infrastructure.exception.*;
import model.entretien.Entretien;
import model.entretien.EntretienId;
import model.entretien.RequetePlanificateur;
import model.repository.Candidats;
import model.repository.Entretiens;
import model.repository.Recruteurs;
import model.repository.Salles;

import java.util.List;
import java.util.UUID;

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

    public void planifier(RequetePlanificateur requete) throws AucunRecruteurAdapte, AucuneSalleLibre, CandidatIntrouvable, RecruteurIndisponible, SalleIndisponible {
        // Given
        CandidatDto candidat = candidats.getCandidatById(requete.getCandidatId());
        if (candidat == null)
            throw new CandidatIntrouvable(requete.getCandidatId());

        List<RecruteurDto> recruteurs = this.recruteurs.findAll();
        List<SalleDto> salles = this.salles.findAll();

        // When
        EntretienId entretienId = new EntretienId(UUID.randomUUID().toString());
        Entretien entretien = new Entretien(entretienId, candidat, requete.getDateEntretien());
        entretien.planifier(recruteurs, salles);

        // Then
        entretiens.add(new EntretienDto(entretien));
    }
}