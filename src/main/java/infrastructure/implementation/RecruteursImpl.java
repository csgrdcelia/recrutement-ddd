package infrastructure.implementation;

import model.Candidat;
import model.Recruteur;
import model.repository.Recruteurs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecruteursImpl implements Recruteurs {
    private final List<Recruteur> allRecruteurs = new ArrayList<>(Arrays.asList(
            new Recruteur(new ArrayList<>(Arrays.asList(LocalDateTime.now())), "java"),
            new Recruteur(new ArrayList<>(Arrays.asList(LocalDateTime.now())), "python"),
            new Recruteur(new ArrayList<>(Arrays.asList(LocalDateTime.now())), "php")));

    public List<Recruteur> recupererTousLesRecruteurs() {
        return allRecruteurs;
    }
}
