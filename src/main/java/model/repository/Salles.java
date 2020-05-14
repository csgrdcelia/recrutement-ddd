package model.repository;

import common.dto.SalleDto;
import java.util.List;

public interface Salles {
    List<SalleDto> findAll();
}
