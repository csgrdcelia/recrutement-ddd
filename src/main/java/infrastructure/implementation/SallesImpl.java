package infrastructure.implementation;

import model.Salle;
import model.repository.Salles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SallesImpl implements Salles {
    private final List<Salle> salles = new ArrayList<>(Arrays.asList(
            new Salle(new ArrayList<>(Arrays.asList(LocalDateTime.now()))),
            new Salle(new ArrayList<>(Arrays.asList(LocalDateTime.now()))),
            new Salle(new ArrayList<>(Arrays.asList(LocalDateTime.now()))),
            new Salle(new ArrayList<>(Arrays.asList(LocalDateTime.now()))),
            new Salle(new ArrayList<>(Arrays.asList(LocalDateTime.now())))));

    public List<Salle> recupererToutesLesSalles() {
        return salles;
    }
}
