package fr.publicissapient.utils;

import fr.publicissapient.exception.EmptyFileException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FileReader {

    public static List<String> lireFichier(String fileName) throws FileNotFoundException, EmptyFileException {
        List<String> lignes = new ArrayList<>();
        URI uri;
        try {
            uri = ClassLoader.getSystemResource(fileName).toURI();
        } catch (URISyntaxException e) {
            throw new FileNotFoundException("Impossible de lire le fichier fournit.");
        }
        try (Stream<String> stream = Files.lines(getPath(uri))) {
            stream.forEach(lignes::add);
        } catch (IOException exception) {
            throw new FileNotFoundException("Impossible de lire le fichier fournit.");
        }
        if (lignes.isEmpty()) {
            throw new EmptyFileException("Le fichier d'entrée est vide");
        }
        return lignes;
    }

    private static Path getPath(URI uri) throws IOException {
        Path path;
        try {
            path = Paths.get(uri);
        } catch (FileSystemNotFoundException ex) {
            Map<String, String> env = new HashMap<>();
            env.put("create", "true");
            FileSystem fs = FileSystems.newFileSystem(uri, env);
            return fs.provider().getPath(uri);
        }
        return path;
    }
}
