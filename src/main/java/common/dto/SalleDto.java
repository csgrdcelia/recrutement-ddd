package common.dto;

import model.entretien.Salle;
import model.entretien.SalleId;

import java.time.LocalDateTime;
import java.util.List;

public class SalleDto {
    private SalleId salleId;
    private List<LocalDateTime> disponibilites;

    public SalleDto(SalleId salleId, List<LocalDateTime> disponibilites) {
        this.salleId = salleId;
        this.disponibilites = disponibilites;
    }

    public SalleDto(Salle salle) {
        this.salleId = salle.getSalleId();
        this.disponibilites = salle.getDisponibilites();
    }

    public SalleId getSalleId() {
        return salleId;
    }

    public List<LocalDateTime> getDisponibilites() {
        return disponibilites;
    }

    @Override
    public String toString() {
        return "SalleDto{" +
                "disponibilites=" + disponibilites +
                '}';
    }
}
