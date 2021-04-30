package fr.publicissapient.direction.service;

import fr.publicissapient.direction.modele.Direction;

import static fr.publicissapient.utils.Constantes.SPLIT_ON;

public class DirectionService {
	public static Direction creerDirectionDepuisLigne(String ligne) {
		String[] split = ligne.split(SPLIT_ON);
		return Direction.valueOf(split[3]);
	}
}
