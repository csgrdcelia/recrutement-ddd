package model.repository;

import common.dto.CandidatDto;
import model.entretien.CandidatId;

public interface Candidats {
    CandidatDto getCandidatById(CandidatId candidatId);
}