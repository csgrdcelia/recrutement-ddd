package use_case;

import common.dto.CandidatDto;
import common.dto.EntretienDto;
import common.dto.RecruteurDto;
import common.dto.SalleDto;
import infrastructure.exception.AucunCandidat;
import infrastructure.exception.AucunRecruteurAdapte;
import infrastructure.exception.AucuneSalleLibre;
import infrastructure.implementation.CandidatsImpl;
import infrastructure.implementation.EntretiensImpl;
import infrastructure.implementation.RecruteursImpl;
import infrastructure.implementation.SallesImpl;
import model.RequetePlanificateur;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PlanifierEntretienTest {
    @Mock
    SallesImpl salles;
    @Mock
    CandidatsImpl candidats;
    @Mock
    RecruteursImpl recruteurs;

    List<SalleDto> allSalles = new ArrayList<>(Arrays.asList(
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00"))))));

    List<CandidatDto> allCandidats = new ArrayList<>(Arrays.asList(
            new CandidatDto("337cdae0-20c7-4b69-9fa9-1abd9b868559", "Arthur", "java",0),
            new CandidatDto("e2bd2071-b2de-449e-b633-ac61662921e2", "Vincent", "python",0),
            new CandidatDto("ef0933e1-57e0-422e-928d-ddebbad77729", "Alexis", "php",0)));

    List<RecruteurDto> allRecruteurs = new ArrayList<>(Arrays.asList(
            new RecruteurDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00"))), "java",15),
            new RecruteurDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00"))), "python",15),
            new RecruteurDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00"))), "php",15)));

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void myTest() {
        assertTrue(true);
    }

    @Test
    public void testMock() {
        Mockito.when(salles.findAll()).thenReturn(allSalles);
        Mockito.when(candidats.findAll()).thenReturn(allCandidats);
        Mockito.when(recruteurs.findAll()).thenReturn(allRecruteurs);
    }

    @Test
    public void testPlanifier() throws AucunRecruteurAdapte, AucuneSalleLibre {
        final CandidatsImpl candidats = new CandidatsImpl();
        final EntretiensImpl entretiens = new EntretiensImpl();
        final RecruteursImpl recruteurs = new RecruteursImpl();
        final SallesImpl salles = new SallesImpl();
        final String candidatId = "e2bd2071-b2de-449e-b633-ac61662921e2";
        final LocalDateTime dateEntretien = LocalDateTime.parse("2020-05-15T15:30:00");

        final RequetePlanificateur requete = new RequetePlanificateur(candidatId, dateEntretien);
        final PlanifierEntretien planifierEntretien = new PlanifierEntretien(candidats, entretiens, recruteurs, salles);

        planifierEntretien.planifier(requete);

        Optional<EntretienDto> optionalEntretienDto = entretiens.findAll().stream().filter(entretien -> entretien.getCandidat().getId().equals(candidatId)).findFirst();

        assertTrue(optionalEntretienDto.isPresent());

        EntretienDto entretienDto = optionalEntretienDto.get();

        assertEquals("python", entretienDto.getRecruteur().getCompetence());
        assertFalse(entretienDto.getRecruteur().getDisponibilites().contains(dateEntretien));
        assertFalse(entretienDto.getSalle().getDisponibilites().contains(dateEntretien));
    }

    @Test
    public void testGetCandidatShouldReturnCandidat() throws AucunCandidat {
        final CandidatsImpl candidats = new CandidatsImpl();
        CandidatDto candidatDto = candidats.getCandidatById("e2bd2071-b2de-449e-b633-ac61662921e2");
        assertEquals("e2bd2071-b2de-449e-b633-ac61662921e2", candidatDto.getId());
    }




}
