package infrastructure.implementation;

import model.Salle;

import java.time.LocalDateTime;
import java.util.List;

public class SallesImpl implements model.repository.Salles {
    @Override
    public List<Salle> getAllSalles() {
        return null; //TODO: implement
    }

    @Override
    public Salle getSalleForDate(List<Salle> salles, LocalDateTime dateEntretien) {
        return null; //TODO: implement
    }
}
