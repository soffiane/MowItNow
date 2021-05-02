package direction;

import fr.publicissapient.direction.modele.Direction;
import fr.publicissapient.direction.service.DirectionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionServiceTest {

    private static DirectionService directionService;

    @BeforeAll
    public static void before() {
        directionService = new DirectionService();
    }

    @Test
    public void testCreerDirectionDepuisLigne() {
        assertEquals(Direction.N, directionService.creerDirectionDepuisLigne("1 1 N"));
        assertEquals(Direction.S, directionService.creerDirectionDepuisLigne("2 3 S"));
        assertEquals(Direction.E, directionService.creerDirectionDepuisLigne("3 2 E"));
        assertEquals(Direction.W, directionService.creerDirectionDepuisLigne("0 0 W"));
    }

}
