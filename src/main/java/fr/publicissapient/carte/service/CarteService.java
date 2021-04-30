package fr.publicissapient.carte.service;

import fr.publicissapient.carte.modele.Case;

import java.util.List;

import static fr.publicissapient.utils.Constantes.SPLIT_ON;

public class CarteService {

	public Case[][] construireCarte(List<String> lignes) {
		String[] split = lignes.get(0).split(SPLIT_ON);
		return new Case[Integer.parseInt(split[0])][Integer.parseInt(split[1])];
	}
}
