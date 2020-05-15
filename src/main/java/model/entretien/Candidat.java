package model.entretien;

import java.util.Objects;

class Candidat {
    private final CandidatId candidatId;
    private final String nom;
    private final String competence;
    private final int nbAnneeExperience;

    public Candidat(CandidatId candidatId, String nom, String competence, int nbAnneeExperience) {
        this.candidatId = candidatId;
        this.nom = nom;
        this.competence = competence;
        this.nbAnneeExperience = nbAnneeExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return Objects.equals(candidatId, candidat.candidatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidatId);
    }
}