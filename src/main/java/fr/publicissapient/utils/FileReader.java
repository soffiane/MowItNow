package fr.publicissapient.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

	public static List<String> lireFichier(File file) throws FileNotFoundException {
		List<String> lignes;
		try (Stream<String> input = Files.lines(Paths.get(file.getPath())))  {
			lignes = input
					.collect(Collectors.toList());
		} catch (IOException e) {
			throw new FileNotFoundException("Erreur durant la lecture du fichier");
		}
		return lignes;
	}
}
