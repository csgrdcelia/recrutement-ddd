package model;

import java.util.Date;

public class Entretien {
    private Candidat candidat;
    private Recruteur recruteur;
    private Salle salle;

    public Entretien(Candidat candidat, Recruteur recruteur, Salle salle) {
        this.candidat = candidat;
        this.recruteur = recruteur;
        this.salle = salle;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public Recruteur getRecruteur() {
        return recruteur;
    }

    public Salle getSalle() {
        return salle;
    }
}
