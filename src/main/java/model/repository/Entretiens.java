package model.repository;

import common.dto.EntretienDto;

import java.util.List;

public interface Entretiens {
    void add(EntretienDto entretien);

    List<EntretienDto> getAll();
}