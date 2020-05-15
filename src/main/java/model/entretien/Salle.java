package model.entretien;

import common.dto.SalleDto;

import java.time.LocalDateTime;
import java.util.List;

public class Salle {
    private SalleId salleId;
    private List<LocalDateTime> disponibilites;

    public Salle(SalleId salleId, List<LocalDateTime> disponibilites) {
        this.salleId = salleId;
        this.disponibilites = disponibilites;
    }

    public Salle(SalleDto salleDto) {
        this.salleId = salleDto.getSalleId();
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

    public SalleId getSalleId() {
        return salleId;
    }
}
