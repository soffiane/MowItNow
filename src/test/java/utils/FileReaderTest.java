package utils;

import fr.publicissapient.utils.FileReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    private final String resourcesPath = "src/test/resources/";

    @Test
    public void testLectureCorrecteFichier() throws IOException {
        List<String> testLines = new ArrayList<>();
        testLines.add("5 5");
        testLines.add("1 2 N");
        testLines.add("GAGAGAGAA");
        testLines.add("3 3 E");
        testLines.add("AADAADADDA");

        List<String> readedLines = FileReader.lireFichier("input_file.txt");

        assertEquals(5, readedLines.size());
        assertTrue(readedLines.get(0).equalsIgnoreCase(testLines.get(0)));
        assertTrue(readedLines.get(1).equalsIgnoreCase(testLines.get(1)));
        assertTrue(readedLines.get(2).equalsIgnoreCase(testLines.get(2)));
        assertTrue(readedLines.get(3).equalsIgnoreCase(testLines.get(3)));
        assertTrue(readedLines.get(4).equalsIgnoreCase(testLines.get(4)));
    }

    @Test
    public void testExceptionfichierVide() {
        assertThrows(
                FileNotFoundException.class, () -> FileReader.lireFichier("")
        );
    }
}
