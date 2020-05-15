package model.entretien;

import common.dto.CandidatDto;
import common.dto.RecruteurDto;
import common.dto.SalleDto;
import infrastructure.exception.AucunRecruteurAdapte;
import infrastructure.exception.AucuneSalleLibre;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Entretien {
    private EntretienId entretienId;
    private CandidatDto candidat;
    private RecruteurDto recruteur;
    private SalleDto salle;
    private LocalDateTime dateEntretien;
    private String status;

    public Entretien(EntretienId entretienId, CandidatDto candidat, LocalDateTime dateEntretien) {
        this.entretienId = entretienId;
        this.candidat = candidat;
        this.dateEntretien = dateEntretien;
    }

    public void planifier(List<RecruteurDto> recruteurs, List<SalleDto> salles) throws AucunRecruteurAdapte, AucuneSalleLibre {
        Salle salle = getSallePourDate(salles, dateEntretien);
        salle.reserver(dateEntretien);

        Recruteur recruteur = getRecruteurPourCandidat(recruteurs, candidat, dateEntretien);
        recruteur.reserver(dateEntretien);

        this.recruteur = new RecruteurDto(recruteur);
        this.salle = new SalleDto(salle);

        status = "planifié";
    }

    public void confirmer() {
        status = "confirmé";
        // TODO: verify
    }

    public void annuler() {
        status = "annulé";
        // TODO: verify
    }

    public void reporter() {
        status = "reporté";
        // TODO: verify
    }

    private Recruteur getRecruteurPourCandidat(List<RecruteurDto> recruteurs, CandidatDto candidat, LocalDateTime dateEntretien) throws AucunRecruteurAdapte {
        final List<Recruteur> recruteursAdaptes = recruteurs
                .stream()
                .map(recruteurDto -> new Recruteur(recruteurDto))
                .filter((recruteur) -> recruteur.peutTesterCandidat(candidat, dateEntretien))
                .collect(Collectors.toList());

        if(recruteursAdaptes.size() == 0) {
            throw new AucunRecruteurAdapte("Aucun recruteur adapté");
        }

        return recruteursAdaptes.get(0);
    }

    private Salle getSallePourDate(List<SalleDto> salles, LocalDateTime dateEntretien) throws AucuneSalleLibre {
        final List<Salle> sallesLibres = salles.stream()
                .map(salleDto -> new Salle(salleDto))
                .filter((salle) -> salle.estLibre(dateEntretien))
                .collect(Collectors.toList());

        if(sallesLibres.size() == 0) {
            throw new AucuneSalleLibre("Aucune salle libre");
        }

        return sallesLibres.get(0);
    }

    public EntretienId getEntretienId() {
        return entretienId;
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

    public LocalDateTime getDateEntretien() {
        return dateEntretien;
    }

    public String getStatus() {
        return status;
    }
}
