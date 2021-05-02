package carte;

import fr.publicissapient.carte.modele.Case;
import fr.publicissapient.carte.service.CarteService;
import fr.publicissapient.position.modele.Position;
import fr.publicissapient.tondeuse.modele.Tondeuse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CarteServiceTest {

    private static CarteService carteService;

    @BeforeAll
    public static void before() {
        carteService = new CarteService();
    }

    @Test
    public void testConstructionCarte() {
        Case[][] carteTest = carteService.construireCarte(singletonList("2 2"));
        assertEquals(2, carteService.calculerTailleCarte(carteTest).getAbscisse());
        assertEquals(2, carteService.calculerTailleCarte(carteTest).getOrdonnee());
    }

    @Test
    public void testLimitesCartes() {
        Case[][] carteTest = carteService.construireCarte(singletonList("2 2"));
        Position nouvellePosition = new Position(3,2);
        assertFalse(carteService.estDansLimitesCarte(carteTest, nouvellePosition));
    }

    @Test
    public void testCaseNonAccessible() {
        Case[][] carteTest = carteService.construireCarte(singletonList("2 2"));
        carteTest[1][1].setTondeuse(new Tondeuse(null,null,null));
        assertFalse(carteService.estCaseAccessible(carteTest[1][1]));
    }
}
