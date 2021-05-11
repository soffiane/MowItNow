package deplacement;

import fr.publicissapient.deplacement.modele.Deplacement;
import fr.publicissapient.deplacement.service.DeplacementService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeplacementServiceTest {

    private static DeplacementService deplacementService;

    @BeforeAll
    public static void before() {
        deplacementService = new DeplacementService();
    }

    @Test
    public void testCreerDeplacementDepuisLigne() {
        assertEquals(singletonList(Deplacement.A), deplacementService.creerListeDeplacementDepuisLigne("A"));
        assertEquals(singletonList(Deplacement.G), deplacementService.creerListeDeplacementDepuisLigne("G"));
        assertEquals(singletonList(Deplacement.D), deplacementService.creerListeDeplacementDepuisLigne("D"));
        assertEquals(asList(Deplacement.A, Deplacement.G, Deplacement.D), deplacementService.creerListeDeplacementDepuisLigne("AGD"));
    }

    @Parameterized.Parameters
    public static Collection deplacement() {
        return Arrays.asList(new Object[][] {
                { Deplacement.A },
                { Deplacement.A },
                { Deplacement.A },
                { Deplacement.A },
                { Deplacement.A }
        });
    }

}
