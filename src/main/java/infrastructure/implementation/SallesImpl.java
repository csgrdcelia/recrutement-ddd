package infrastructure.implementation;

import common.dto.SalleDto;
import model.Salle;
import model.repository.Salles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SallesImpl implements Salles {
    private final List<SalleDto> salles = new ArrayList<>(Arrays.asList(
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.now()))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.now()))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.now()))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.now()))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.now())))));

    public List<SalleDto> findAll() {
        return salles;
    }
}
