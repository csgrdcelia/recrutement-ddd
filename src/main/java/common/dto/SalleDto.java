package common.dto;

import model.Salle;

import java.time.LocalDateTime;
import java.util.List;

public class SalleDto {

    private List<LocalDateTime> disponibilites;

    public SalleDto(List<LocalDateTime> disponibilites) {
        this.disponibilites = disponibilites;
    }

    public SalleDto(Salle salle) {
        this.disponibilites = getDisponibilites();
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
