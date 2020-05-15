package model.entretien;

import common.dto.RecruteurDto;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RecruteurTest {

    @Test
    public void testPeutTesterCandidat() {

    }

    @Test
    public void test_reserver() {
        LocalDateTime date = LocalDateTime.parse("2020-05-15T15:30:00");
        List<LocalDateTime> disponibilities = new ArrayList<>();
        disponibilities.add(date);
        Recruteur recruteur = new Recruteur(new RecruteurId("337cdae0-20c7-4b69-9fa9-1abd9b868510"), disponibilities, "java", 12);
        recruteur.reserver(date);
        assertFalse(recruteur.estDisponible(date));
    }

    @Test
    public void test_estDisponible_estVrai() {
        List<LocalDateTime> disponibilities = new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")));
        Recruteur recruteur = new Recruteur(new RecruteurId("337cdae0-20c7-4b69-9fa9-1abd9b868510"), disponibilities, "java", 12);
        assertTrue(recruteur.estDisponible(LocalDateTime.parse("2020-05-15T15:30:00")));
    }

    @Test
    public void test_estDisponible_estFaux() {
        List<LocalDateTime> disponibilities = new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")));
        Recruteur recruteur = new Recruteur(new RecruteurId("337cdae0-20c7-4b69-9fa9-1abd9b868510"), disponibilities, "java", 12);
        assertFalse(recruteur.estDisponible(LocalDateTime.parse("2020-06-15T15:30:00")));
    }
}