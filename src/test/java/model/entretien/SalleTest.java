package model.entretien;

import infrastructure.exception.SalleIndisponible;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class SalleTest {

    @Test(expected = SalleIndisponible.class)
    public void test_reserver_estIndisponible() throws SalleIndisponible {
        LocalDateTime dateDisponible = LocalDateTime.parse("2020-05-15T15:30:00");
        LocalDateTime dateIndisponible = LocalDateTime.parse("2020-06-15T15:30:00");
        List<LocalDateTime> disponibilities = new ArrayList<>();
        disponibilities.add(dateDisponible);
        Salle salle = new Salle(new SalleId(UUID.randomUUID().toString()), disponibilities);
        salle.reserver(dateIndisponible);
    }

    @Test
    public void test_reserver() throws SalleIndisponible {
        LocalDateTime dateDisponible = LocalDateTime.parse("2020-05-15T15:30:00");
        List<LocalDateTime> disponibilities = new ArrayList<>();
        disponibilities.add(dateDisponible);
        Salle salle = new Salle(new SalleId(UUID.randomUUID().toString()), disponibilities);
        salle.reserver(dateDisponible);
    }

    @Test
    public void test_estLibre_estVrai() {
        List<LocalDateTime> disponibilities = new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")));
        Salle salle = new Salle(new SalleId(UUID.randomUUID().toString()), disponibilities);
        assertTrue(salle.estLibre(LocalDateTime.parse("2020-05-15T15:30:00")));
    }

    @Test
    public void test_estLibre_estFaux() {
        List<LocalDateTime> disponibilities = new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")));
        Salle salle = new Salle(new SalleId(UUID.randomUUID().toString()), disponibilities);
        assertFalse(salle.estLibre(LocalDateTime.parse("2020-06-15T15:30:00")));
    }
}