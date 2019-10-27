package test;

import exception.InvalidInputException;
import main.Programme;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProgrammeTest {


    @Test
    public void testNominal(){
        assertEquals("1 3 N" + System.getProperty("line.separator") +
                "5 1 E",Programme.lireFichier(new File("test/ressources/input_file.txt")),"Cas de test standard");
    }

    @Test
    public void testNominalSortiePelouse(){
        assertEquals("0 0 S" + System.getProperty("line.separator") +
                "0 0 N",Programme.lireFichier(new File("test/ressources/input_file2.txt")),"On teste la sortie des dimenions de la pelouse");
    }

    @Test
    public void testErreurTaillePelouse() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> Programme.lireFichier(new File("test/ressources/input_file_wrong_line1.txt"))
        );

        assertEquals("La taille de la pelouse n'est pas valide", exception.getMessage(),"On teste le cas d'erreur pour le format du fichier, la ligne qui determine la taille de la pelouse");
    }

    @Test
    public void testErreurCoordonnesTondeuse() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> Programme.lireFichier(new File("test/ressources/input_file_wrong_line2.txt"))
        );

        assertEquals("Les coordonnées de la tondeuse ne sont pas valides", exception.getMessage(), "On teste le cas d'erreur pour le format du fichier, la ligne qui positionne la tondeuse");
    }
    @Test
    public void testErreurInstructions() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> Programme.lireFichier(new File("test/ressources/input_file_wrong_line3.txt"))
        );

        assertEquals("Les instructions de la tondeuse ne sont pas valides", exception.getMessage(),"On teste le cas d'erreur pour le format du fichier, la ligne avec les commandes");
    }
}