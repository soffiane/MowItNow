package fr.publicissapient.position.service;

import fr.publicissapient.position.modele.Position;

import static fr.publicissapient.utils.Constantes.SPLIT_ON;

public class PositionService {

	public Position creerPositionDepuisLigne(String ligne) {
		String[] split = ligne.split(SPLIT_ON);
		return new Position(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
	}
}
