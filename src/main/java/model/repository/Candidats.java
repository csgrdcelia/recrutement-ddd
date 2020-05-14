package model.repository;

import model.Candidat;

import java.util.List;

public interface Candidats {
    Candidat getCandidatById(String id);
    List<Candidat> recupererTousLesCandidats();
}