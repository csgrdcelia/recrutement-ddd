package use_case;

import infrastructure.exception.AucunRecruteurAdapte;
import infrastructure.exception.AucuneSalleLibre;
import model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PlanifierEntretien {
    private final model.repository.Candidats candidats;
    private final model.repository.Entretiens entretienRepository;
    private final model.repository.Recruteurs recruteurRepository;
    private final model.repository.Salles salles;

    public PlanifierEntretien(model.repository.Candidats candidats, model.repository.Entretiens entretienRepository, model.repository.Recruteurs recruteurRepository, model.repository.Salles salles) {
        this.candidats = candidats;
        this.entretienRepository = entretienRepository;
        this.recruteurRepository = recruteurRepository;
        this.salles = salles;
    }

    public void planifier(PlanificateurRequest request) throws AucunRecruteurAdapte, AucuneSalleLibre {
        // Given
        Candidat candidat = candidats.getCandidatById(request.getCandidatId());
        List<Recruteur> recruteurs = recruteurRepository.getAllRecruteurs();
        List<Salle> salles = this.salles.getAllSalles();

        LocalDateTime dateEntretien = request.getDateEntretien();
        Recruteur recruteurAdapte = getRecruteurPourCandidat(recruteurs, candidat, dateEntretien);
        Salle salleDisponible = getSallePourDate(salles, dateEntretien);

        // When
        Entretien entretien = new Entretien(candidat, recruteurAdapte, salleDisponible);

        // Then
        entretienRepository.add(entretien);
    }

    private Salle getSallePourDate(List<Salle> salles, LocalDateTime dateEntretien) throws AucuneSalleLibre {
        final List<Salle> sallesLibres = salles.stream()
                .filter((salle) -> estLibre(salle, dateEntretien))
                .collect(Collectors.toList());

        if(sallesLibres.size() == 0) {
            throw new AucuneSalleLibre("Aucune salle libre");
        }

        return sallesLibres.get(0);
    }

    private boolean estLibre(Salle salle, LocalDateTime dateEntretien) {
        return salle.getDisponibilites().contains(dateEntretien);
    }

    private Recruteur getRecruteurPourCandidat(List<Recruteur> recruteurs, Candidat candidat, LocalDateTime dateEntretien) throws AucunRecruteurAdapte {
        final List<Recruteur> recruteursAdaptes = recruteurs.stream()
                .filter((recruteur) -> estAdaptePourCandidat(recruteur, candidat, dateEntretien))
                .collect(Collectors.toList());

        if(recruteursAdaptes.size() == 0) {
            throw new AucunRecruteurAdapte("Aucun recruteur adapté");
        }

        return recruteursAdaptes.get(0);
    }

    private boolean estAdaptePourCandidat(Recruteur recruteur, Candidat candidat, LocalDateTime dateEntretien) {
        return recruteur.estDisponible(dateEntretien) &&
                recruteur.getCompetence().equals(candidat.getCompetence()) &&
                recruteur.getNbAnneeExperience() > candidat.getNbAnneeExperience();
    }
}