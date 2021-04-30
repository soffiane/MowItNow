package fr.publicissapient.tondeuse.service;

import fr.publicissapient.carte.modele.Case;
import fr.publicissapient.deplacement.service.DeplacementService;
import fr.publicissapient.direction.service.DirectionService;
import fr.publicissapient.position.service.PositionService;
import fr.publicissapient.direction.modele.Direction;
import fr.publicissapient.position.modele.Position;
import fr.publicissapient.deplacement.modele.Deplacement;
import fr.publicissapient.tondeuse.modele.Tondeuse;

import java.util.ArrayList;
import java.util.List;

import static fr.publicissapient.direction.modele.Direction.*;

public class TondeuseService {

	public void placerTondeusesSurCarte(List<String> lignes) {

	}

	public List<Tondeuse> recupererListeTondeuses(List<String> lignes) {
		List<Tondeuse> tondeuses = new ArrayList<>();
		for(int i = 1;i<lignes.size();i+=2){
			Position positionInitiale = PositionService.creerPositionDepuisLigne(lignes.get(i));
			Direction directionInitiale = DirectionService.creerDirectionDepuisLigne(lignes.get(i));
			List<Deplacement> deplacements = DeplacementService.creerListeDeplacementDepuisLigne(lignes.get(i+1));
			tondeuses.add(new Tondeuse(positionInitiale,directionInitiale,deplacements));
		}
		return tondeuses;
	}

	/*public String jouerDeplacementsTondeuses(Case[][] carte, List<Tondeuse> tondeuses) {
		switch (tondeuse.getOrientation()) {
			case E:
				if (estUnDeplacementPossible(tondeuse.getPosition().getAbscisse() + 1, tondeuse.getPosition().getOrdonnee(), dimensionPelouseX, dimensionPelouseY)) {
					tondeuse.getPosition().setAbscisse(tondeuse.getPosition().getAbscisse() + 1);
				}
				break;
			case S:
				if (estUnDeplacementPossible(tondeuse.getPosition().getAbscisse(), tondeuse.getPosition().getOrdonnee() - 1, dimensionPelouseX, dimensionPelouseY)) {
					tondeuse.getPosition().setOrdonnee(tondeuse.getPosition().getOrdonnee() - 1);
				}
				break;
			case W:
				if (estUnDeplacementPossible(tondeuse.getPosition().getAbscisse() - 1, tondeuse.getPosition().getOrdonnee(), dimensionPelouseX, dimensionPelouseY)) {
					tondeuse.getPosition().setAbscisse(tondeuse.getPosition().getAbscisse() - 1);
				}
				break;
			case N:
				if (estUnDeplacementPossible(tondeuse.getPosition().getAbscisse(), tondeuse.getPosition().getOrdonnee() + 1, dimensionPelouseX, dimensionPelouseY)) {
					tondeuse.getPosition().setOrdonnee(tondeuse.getPosition().getOrdonnee() + 1);
				}
				break;
			default:
		}
		return null;
	}

	private boolean estUnDeplacementPossible(int futurX, int futurY, int dimensionPelouseX, int dimensionPelouseY) {
		return futurX >= 0 && futurX <= dimensionPelouseX && futurY >= 0 && futurY <= dimensionPelouseY;
	}


	public void tournerADroite() {
		tourner(S, W, N, E);
	}

	public void tournerAGauche() {
		tourner(N, E, S, W);
	}

	private void tourner(Direction direction1, Direction direction2, Direction direction3, Direction direction4) {
		switch (this.getOrientation()) {
			case E:
				this.setOrientation(direction1);
				break;
			case S:
				this.setOrientation(direction2);
				break;
			case W:
				this.setOrientation(direction3);
				break;
			case N:
				this.setOrientation(direction4);
				break;
			default:
		}
	}*/


}
