package model.entretien;

import common.dto.CandidatDto;
import common.dto.RecruteurDto;
import infrastructure.exception.RecruteurIndisponible;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RecruteurTest {

    @Test
    public void test_peutTesterCandidat_estVrai() {
        LocalDateTime date = LocalDateTime.parse("2020-05-15T15:30:00");
        List<LocalDateTime> disponibilities = new ArrayList<>();
        disponibilities.add(date);
        Recruteur recruteur = new Recruteur(new RecruteurId("337cdae0-20c7-4b69-9fa9-1abd9b868510"), disponibilities, "java", 12);
        CandidatDto candidat = new CandidatDto(new CandidatId("337cdae0-20c7-4b69-9fa9-1abd9b868559"),  "Arthur", "java", 0);

        assertTrue(recruteur.peutTesterCandidat(candidat, date));
    }

    @Test
    public void test_peutTesterCandidat_avecPlusDExperience_estFaux() {
        LocalDateTime date = LocalDateTime.parse("2020-05-15T15:30:00");
        List<LocalDateTime> disponibilities = new ArrayList<>();
        disponibilities.add(date);
        Recruteur recruteur = new Recruteur(new RecruteurId("337cdae0-20c7-4b69-9fa9-1abd9b868510"), disponibilities, "java", 5);
        CandidatDto candidat = new CandidatDto(new CandidatId("337cdae0-20c7-4b69-9fa9-1abd9b868559"),  "Arthur", "java", 6);

        assertFalse(recruteur.peutTesterCandidat(candidat, date));
    }

    @Test
    public void test_peutTesterCandidat_avecDifferenteTechno_estFaux() {
        LocalDateTime date = LocalDateTime.parse("2020-05-15T15:30:00");
        List<LocalDateTime> disponibilities = new ArrayList<>();
        disponibilities.add(date);
        Recruteur recruteur = new Recruteur(new RecruteurId("337cdae0-20c7-4b69-9fa9-1abd9b868510"), disponibilities, "java", 12);
        CandidatDto candidat = new CandidatDto(new CandidatId("337cdae0-20c7-4b69-9fa9-1abd9b868559"),  "Arthur", "python", 6);

        assertFalse(recruteur.peutTesterCandidat(candidat, date));
    }

    @Test(expected = RecruteurIndisponible.class)
    public void test_reserver_estIndisponible() throws RecruteurIndisponible {
        LocalDateTime dateDisponible = LocalDateTime.parse("2020-05-15T15:30:00");
        LocalDateTime dateIndisponible = LocalDateTime.parse("2020-06-15T15:30:00");
        List<LocalDateTime> disponibilities = new ArrayList<>();
        disponibilities.add(dateDisponible);
        Recruteur recruteur = new Recruteur(new RecruteurId("337cdae0-20c7-4b69-9fa9-1abd9b868510"), disponibilities, "java", 12);
        recruteur.reserver(dateIndisponible);
    }

    @Test
    public void test_reserver() throws RecruteurIndisponible {
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