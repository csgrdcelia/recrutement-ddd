package infrastructure.implementation;

import common.dto.CandidatDto;
import model.Candidat;
import model.repository.Candidats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandidatsImpl implements Candidats {

    private final List<CandidatDto> allCandidats = new ArrayList<>(Arrays.asList(new CandidatDto("Arthur", "java"),
            new CandidatDto("Vincent", "python"), new CandidatDto("Alexis", "php")));

    public Candidat getCandidatById(String id) {
        return null;
    }

    @Override
    public List<Candidat> recupererTousLesCandidats() {
        return allCandidats;
    }
}
