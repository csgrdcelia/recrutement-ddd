package infrastructure.implementation;

import common.dto.CandidatDto;
import common.dto.SalleDto;
import model.repository.Candidats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CandidatsImpl implements Candidats {

    private final List<CandidatDto> allCandidats = new ArrayList<>(Arrays.asList(
            new CandidatDto("337cdae0-20c7-4b69-9fa9-1abd9b868559", "Arthur", "java",0),
            new CandidatDto("e2bd2071-b2de-449e-b633-ac61662921e2", "Vincent", "python",0),
            new CandidatDto("ef0933e1-57e0-422e-928d-ddebbad77729", "Alexis", "php",0)));

    public CandidatDto getCandidatById(String id) {
        List<CandidatDto> candidats = allCandidats.stream()
                .filter(candidatDto -> candidatDto.getId().equals(id))
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
