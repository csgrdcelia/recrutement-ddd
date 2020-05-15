package infrastructure.implementation;

import common.dto.CandidatDto;
import model.Candidat;
import model.repository.Candidats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandidatsImpl implements Candidats {

    private final List<CandidatDto> allCandidats = new ArrayList<>(Arrays.asList(
            new CandidatDto("337cdae0-20c7-4b69-9fa9-1abd9b868559", "Arthur", "java"),
            new CandidatDto("e2bd2071-b2de-449e-b633-ac61662921e2", "Vincent", "python"),
            new CandidatDto("ef0933e1-57e0-422e-928d-ddebbad77729", "Alexis", "php")));

    public CandidatDto getCandidatById(String id) {
        return null;
    }
}
