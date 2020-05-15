package infrastructure.implementation;

import common.dto.EntretienDto;
import model.repository.Entretiens;

import java.util.ArrayList;
import java.util.List;

public class EntretiensImpl implements Entretiens {
    private final List<EntretienDto> entretiens = new ArrayList<>();

    @Override
    public void add(EntretienDto entretien) {
        entretiens.add(entretien);
    }

    @Override
    public List<EntretienDto> findAll() {
        return entretiens;
    }
}
