package model.repository;

import common.dto.CandidatDto;
import model.Candidat;

import java.util.List;

public interface Candidats {
    CandidatDto getCandidatById(String id);
    List<CandidatDto> recupererTousLesCandidats();
}