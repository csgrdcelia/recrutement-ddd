package infrastructure.implementation;

import model.Candidat;
import model.repository.Candidats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandidatsImpl implements Candidats {

    private final List<Candidat> allCandidats = new ArrayList<>(Arrays.asList(new Candidat("Arthur", "java"),
            new Candidat("Vincent", "python"), new Candidat("Alexis", "php")));

    public Candidat getCandidatById(String id) {
        return null;
    }

    @Override
    public List<Candidat> recupererTousLesCandidats() {
        return allCandidats;
    }
}
