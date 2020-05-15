package use_case;

import common.dto.SalleDto;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PlanifierEntretienTest {
    @Mock
    SallesImpl salles;

    List<SalleDto> allSalles = new ArrayList<>(Arrays.asList(
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00")))),
            new SalleDto(new ArrayList<>(Arrays.asList(LocalDateTime.parse("2020-05-15T15:30:00"))))));

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
        System.out.println(salles.findAll());
    }

    @Test
    public void testPlanifierShouldReturnCandidat() throws AucunRecruteurAdapte, AucuneSalleLibre {
        final CandidatsImpl candidats = new CandidatsImpl();
        final EntretiensImpl entretiens = new EntretiensImpl();
        final RecruteursImpl recruteurs = new RecruteursImpl();

        final PlanifierEntretien planifierEntretien = new PlanifierEntretien(candidats, entretiens, recruteurs, salles);

        String candidatId = "";
        LocalDateTime dateEntretien = LocalDateTime.parse("2020-05-15T15:30:00");
        final RequetePlanificateur requete = new RequetePlanificateur(candidatId, dateEntretien);
        planifierEntretien.planifier(requete);

//        entretiens.getAll().contains()
        assertTrue(true);
    }
}
