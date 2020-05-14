package model.repository;

import model.Candidat;
import model.Recruteur;

import java.util.List;

public interface Recruteurs {

    List<Recruteur> getAllRecruteurs();

    Recruteur getRecruteurForCandidat(List<Recruteur> recruteurs, Candidat candidat);
}
