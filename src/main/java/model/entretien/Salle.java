package model.entretien;

import common.dto.SalleDto;
import infrastructure.exception.SalleIndisponible;

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

    public void reserver(LocalDateTime date) throws SalleIndisponible{
        if (!estLibre(date))
            throw new SalleIndisponible(date);
        disponibilites.remove(date);
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
