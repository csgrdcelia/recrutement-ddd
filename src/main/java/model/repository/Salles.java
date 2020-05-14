package model.repository;

import model.Salle;

import java.time.LocalDateTime;
import java.util.List;

public interface Salles {
    List<Salle> recupererToutesLesSalles();
}
