package fr.publicissapient.carte.service;

import fr.publicissapient.carte.modele.Case;
import fr.publicissapient.position.modele.Position;

import java.util.List;

import static fr.publicissapient.utils.Constantes.SPLIT_ON;

public class CarteService {

    public Case[][] construireCarte(List<String> lignes) {
        String[] split = lignes.get(0).split(SPLIT_ON);
        return new Case[Integer.parseInt(split[0])][Integer.parseInt(split[1])];
    }

    public boolean estCaseAccessible(Case caseDepart) {
        return caseDepart.getTondeuse() == null;
    }

    public boolean estDansLimitesCarte(Case[][] carte, Position nouvellePosition) {
        Position tailleCarte = calculerTailleCarte(carte);
        return (
                tailleCarte.getOrdonnee() > nouvellePosition.getOrdonnee() &&
                        tailleCarte.getAbscisse() > nouvellePosition.getAbscisse() &&
                        nouvellePosition.getOrdonnee() >= 0 &&
                        nouvellePosition.getAbscisse() >= 0
        );
    }

    private Position calculerTailleCarte(Case[][] carte) {
        Position position = new Position();
        position.setOrdonnee(carte.length);
        position.setAbscisse(carte[0].length);
        return position;
    }
}
