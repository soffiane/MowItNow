package test;

import main.Programme;
import org.junit.jupiter.api.Test;

class ProgrammeTest {

    @Test
    public void testNominal(){
        Programme.main(new String[]{"test/ressources/input_file.txt"});
    }

    @Test
    public void testNominalSortiePelouse(){
        Programme.main(new String[]{"test/ressources/input_file2.txt"});
    }

    @Test
    public void testErreurTaillePelouse() {
        Programme.main(new String[]{"test/ressources/input_file_wrong_line1.txt"});
    }

    @Test
    public void testErreurCoordonnesTondeuse() {
        Programme.main(new String[]{"test/ressources/input_file_wrong_line2.txt"});
    }
    @Test
    public void testErreurInstructions() {
        Programme.main(new String[]{"test/ressources/input_file_wrong_line3.txt"});
    }
}