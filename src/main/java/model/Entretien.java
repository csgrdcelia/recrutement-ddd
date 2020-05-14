package model;

import common.dto.CandidatDto;

import java.util.Date;

public class Entretien {
    private CandidatDto candidat;
    private Recruteur recruteur;
    private Salle salle;

    public Entretien(CandidatDto candidat, Recruteur recruteur, Salle salle) {
        this.candidat = candidat;
        this.recruteur = recruteur;
        this.salle = salle;
    }

    public CandidatDto getCandidat() {
        return candidat;
    }

    public Recruteur getRecruteur() {
        return recruteur;
    }

    public Salle getSalle() {
        return salle;
    }


}
