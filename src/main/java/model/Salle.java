package model;

import java.time.LocalDateTime;
import java.util.List;

public class Salle {
    private List<LocalDateTime> disponibilites;

    public Salle(List<LocalDateTime> disponibilites) {
        this.disponibilites = disponibilites;
    }

    public List<LocalDateTime> getDisponibilites() {
        return disponibilites;
    }

}
