package fr.publicissapient.deplacement.service;

import fr.publicissapient.deplacement.modele.Deplacement;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class DeplacementService {

	public static List<Deplacement> creerListeDeplacementDepuisLigne(String ligne) {
		char[] deplacements = ligne.toCharArray();
		return IntStream.range(0, deplacements.length)
				.mapToObj(i -> deplacements[i])
				.map(deplacement -> Deplacement.valueOf(deplacement.toString()))
				.collect(toList());
	}
}
