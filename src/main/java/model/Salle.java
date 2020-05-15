package model;

import common.dto.SalleDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Salle {
    private List<LocalDateTime> disponibilites;

    public Salle(List<LocalDateTime> disponibilites) {
        this.disponibilites = disponibilites;
    }

    public Salle(SalleDto salleDto) {
        this.disponibilites = salleDto.getDisponibilites();
    }

    public void reserver(LocalDateTime date) {
        disponibilites.remove(date);
        //TODO: test
    }

    public boolean estLibre(LocalDateTime dateEntretien) {
        return this.disponibilites.stream().filter(disponibilite -> disponibilite.equals(dateEntretien)).count() == 1;
    }

    public List<LocalDateTime> getDisponibilites() {
        return disponibilites;
    }
}
