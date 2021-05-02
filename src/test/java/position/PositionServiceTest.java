package position;

import fr.publicissapient.position.modele.Position;
import fr.publicissapient.position.service.PositionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionServiceTest {

    private static PositionService positionService;

    @BeforeAll
    public static void before() {
        positionService = new PositionService();
    }

    @Test
    public void testCreerDirectionDepuisLigne() {
        Position positionTest = positionService.creerPositionDepuisLigne("1 2 N");
        assertEquals(1, positionTest.getAbscisse());
        assertEquals(2, positionTest.getOrdonnee());
    }
}
