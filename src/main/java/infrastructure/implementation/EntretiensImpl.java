package infrastructure.implementation;

import model.Entretien;
import model.repository.Entretiens;

import java.util.ArrayList;
import java.util.List;

public class EntretiensImpl implements Entretiens {
    private final List<Entretien> entretiens = new ArrayList<>();

    @Override
    public void add(Entretien entretien) {
        entretiens.add(entretien);
    }
}
