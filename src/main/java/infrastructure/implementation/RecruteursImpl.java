package infrastructure.implementation;

import common.dto.RecruteurDto;
import model.Recruteur;
import model.repository.Recruteurs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecruteursImpl implements Recruteurs {
    private final List<RecruteurDto> allRecruteurs = new ArrayList<>(Arrays.asList(
            new RecruteurDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00"))), "java",15),
            new RecruteurDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00"))), "python",15),
            new RecruteurDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00"))), "php",15)));

    public List<RecruteurDto> findAll() {
        return allRecruteurs;
    }
}
