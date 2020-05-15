package infrastructure.implementation;

import common.dto.SalleDto;
import model.entretien.SalleId;
import model.repository.Salles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SallesImpl implements Salles {
    private final List<SalleDto> salles = new ArrayList<>(Arrays.asList(
            new SalleDto(new SalleId(UUID.randomUUID().toString()), new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new SalleId(UUID.randomUUID().toString()), new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new SalleId(UUID.randomUUID().toString()), new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new SalleId(UUID.randomUUID().toString()), new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new SalleId(UUID.randomUUID().toString()), new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00"))))));

    public List<SalleDto> findAll() {
        return salles;
    }
}
