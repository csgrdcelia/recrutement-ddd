package infrastructure.implementation;

import common.dto.CandidatDto;
import model.entretien.CandidatId;
import model.repository.Candidats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CandidatsImpl implements Candidats {

    private final List<CandidatDto> allCandidats = new ArrayList<>(Arrays.asList(
            new CandidatDto(new CandidatId("337cdae0-20c7-4b69-9fa9-1abd9b868559"),  "Arthur", "java", 0),
            new CandidatDto(new CandidatId("e2bd2071-b2de-449e-b633-ac61662921e2"), "Vincent", "python", 0),
            new CandidatDto(new CandidatId("ef0933e1-57e0-422e-928d-ddebbad77729"), "Alexis", "php", 0)));

    public CandidatDto getCandidatById(CandidatId candidatId) {
        List<CandidatDto> candidats = allCandidats.stream()
                .filter(candidatDto -> candidatDto.getCandidatId().equals(candidatId))
                .collect(Collectors.toList());
        if(candidats.size() == 1)
            return candidats.get(0);
        else
            return null;
    }

    public List<CandidatDto> findAll() {
        return allCandidats;
    }

}
