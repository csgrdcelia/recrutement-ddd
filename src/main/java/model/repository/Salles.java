package model.repository;

import model.Salle;

import java.time.LocalDateTime;
import java.util.List;

public interface Salles {
    List<Salle> getAllSalles();

    Salle getSalleForDate(List<Salle> salles, LocalDateTime dateEntretien);
}
