package use_case;

import common.dto.CandidatDto;
import infrastructure.exception.AucunRecruteurAdapte;
import infrastructure.exception.AucuneSalleLibre;
import model.*;
import model.repository.Candidats;
import model.repository.Entretiens;
import model.repository.Recruteurs;
import model.repository.Salles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PlanifierEntretien {
    private final model.repository.Candidats candidats;
    private final model.repository.Entretiens entretienRepository;
    private final model.repository.Recruteurs recruteurRepository;
    private final model.repository.Salles salles;

    public PlanifierEntretien(Candidats candidats, Entretiens entretienRepository, Recruteurs recruteurRepository, Salles salles) {
        this.candidats = candidats;
        this.entretienRepository = entretienRepository;
        this.recruteurRepository = recruteurRepository;
        this.salles = salles;
    }

    public void planifier(PlanificateurRequest request) throws AucunRecruteurAdapte, AucuneSalleLibre {
        // Given
        CandidatDto candidat = candidats.getCandidatById(request.getCandidatId());
        List<Recruteur> recruteurs = recruteurRepository.recupererTousLesRecruteurs();
        List<Salle> salles = this.salles.recupererToutesLesSalles();

        LocalDateTime dateEntretien = request.getDateEntretien();
        Recruteur recruteurAdapte = getRecruteurPourCandidat(recruteurs, candidat, dateEntretien);
        Salle salleDisponible = getSallePourDate(salles, dateEntretien);

        // When
        Entretien entretien = new Entretien(candidat, recruteurAdapte, salleDisponible);

        // Then
        entretienRepository.add(entretien);
    }

    private Recruteur getRecruteurPourCandidat(List<Recruteur> recruteurs, CandidatDto candidat, LocalDateTime dateEntretien) throws AucunRecruteurAdapte {
        final List<Recruteur> recruteursAdaptes = recruteurs.stream()
                .filter((recruteur) -> recruteur.peutTesterCandidat(candidat, dateEntretien))
                .collect(Collectors.toList());

        if(recruteursAdaptes.size() == 0) {
            throw new AucunRecruteurAdapte("Aucun recruteur adapté");
        }

        return recruteursAdaptes.get(0);
    }

    private Salle getSallePourDate(List<Salle> salles, LocalDateTime dateEntretien) throws AucuneSalleLibre {
        final List<Salle> sallesLibres = salles.stream()
                .filter((salle) -> salle.estLibre(dateEntretien))
                .collect(Collectors.toList());

        if(sallesLibres.size() == 0) {
            throw new AucuneSalleLibre("Aucune salle libre");
        }

        return sallesLibres.get(0);
    }
}