package fr.publicissapient.tondeuse.service;

import fr.publicissapient.carte.modele.Case;
import fr.publicissapient.carte.service.CarteService;
import fr.publicissapient.deplacement.modele.Deplacement;
import fr.publicissapient.deplacement.service.DeplacementService;
import fr.publicissapient.direction.modele.Direction;
import fr.publicissapient.direction.service.DirectionService;
import fr.publicissapient.exception.InvalidDeplacementException;
import fr.publicissapient.exception.InvalidPlacementException;
import fr.publicissapient.position.modele.Position;
import fr.publicissapient.position.service.PositionService;
import fr.publicissapient.tondeuse.modele.Tondeuse;

import java.util.ArrayList;
import java.util.List;

import static fr.publicissapient.direction.modele.Direction.*;

public class TondeuseService {

    PositionService positionService;
    DirectionService directionService;
    DeplacementService deplacementService;
    CarteService carteService;

    public TondeuseService(PositionService positionService, DirectionService directionService, DeplacementService deplacementService, CarteService carteService) {
        this.positionService = positionService;
        this.directionService = directionService;
        this.deplacementService = deplacementService;
        this.carteService = carteService;
    }

    public List<Tondeuse> recupererListeTondeuses(List<String> lignes) {
        List<Tondeuse> tondeuses = new ArrayList<>();
        for (int i = 1; i < lignes.size(); i += 2) {
            Position positionInitiale = positionService.creerPositionDepuisLigne(lignes.get(i));
            Direction directionInitiale = directionService.creerDirectionDepuisLigne(lignes.get(i));
            List<Deplacement> deplacements = deplacementService.creerListeDeplacementDepuisLigne(lignes.get(i + 1));
            tondeuses.add(new Tondeuse(positionInitiale, directionInitiale, deplacements));
        }
        return tondeuses;
    }

    public void placerTondeusesSurCarte(Case[][] carte, List<Tondeuse> tondeuses) {
        for (Tondeuse tondeuse : tondeuses) {
            Case caseDepart = carte[tondeuse.getPosition().getAbscisse()][tondeuse.getPosition().getOrdonnee()];
            if (carteService.estCaseAccessible(caseDepart)) {
                caseDepart.setTondeuse(tondeuse);
            } else {
                throw new InvalidPlacementException("Impossible de placer la tondeuse sur la case " + caseDepart.getPosX() + " " + caseDepart.getPosY());
            }
        }
    }

    public String jouerDeplacementsTondeuses(Case[][] carte, List<Tondeuse> tondeuses) {
        StringBuilder result = new StringBuilder();
        for (Tondeuse tondeuse : tondeuses) {
            tondeuse.getDeplacements().forEach(deplacement -> resoudreDeplacement(tondeuse, deplacement, carte));
            result.append(tondeuse.getPosition().getAbscisse()).append(tondeuse.getPosition().getOrdonnee()).append(System.lineSeparator());
        }
        return result.toString();
    }

    private void resoudreDeplacement(Tondeuse tondeuse, Deplacement deplacement, Case[][] carte) {
        switch (deplacement) {
            case D:
                tournerADroite(tondeuse);
                break;
            case G:
                tournerAGauche(tondeuse);
                break;
            case A:
                avancer(tondeuse, carte);
                break;
            default:
                throw new InvalidDeplacementException("deplacement invalide");
        }
    }

    private void tournerAGauche(Tondeuse tondeuse) {
        switch (tondeuse.getOrientation()) {
            case E:
                tondeuse.setOrientation(N);
                break;
            case S:
                tondeuse.setOrientation(E);
                break;
            case W:
                tondeuse.setOrientation(S);
                break;
            case N:
                tondeuse.setOrientation(W);
                break;
            default:
        }
    }

    private void tournerADroite(Tondeuse tondeuse) {
        switch (tondeuse.getOrientation()) {
            case E:
                tondeuse.setOrientation(S);
                break;
            case S:
                tondeuse.setOrientation(W);
                break;
            case W:
                tondeuse.setOrientation(N);
                break;
            case N:
                tondeuse.setOrientation(E);
                break;
            default:
        }
    }

    private void avancer(Tondeuse tondeuse, Case[][] carte) {
        Position nouvellePosition = this.calculerNouvellePosition(tondeuse);
        if (carteService.estDansLimitesCarte(carte, nouvellePosition)) {
            Case caseEnCours = carte[tondeuse.getPosition().getOrdonnee()][tondeuse.getPosition().getAbscisse()];
            Case nouvelleCase = carte[nouvellePosition.getOrdonnee()][nouvellePosition.getAbscisse()];

            if (carteService.estCaseAccessible(nouvelleCase)) {
                caseEnCours.setTondeuse(null);
                tondeuse.setPosition(nouvellePosition);
                nouvelleCase.setTondeuse(tondeuse);
                System.out.println("La tondeuse vient d'avancer d'une case.");
            } else {
                System.out.println("La tondeuse souhaite avancer sur une position non accessible. Ce déplacement est ignoré.");
            }
        } else {
            System.out.println("Le déplacement n'est pas possible. Déplacement ignoré");
        }

    }

    private Position calculerNouvellePosition(Tondeuse tondeuse) {
        Position nouvellePosition = new Position();
        Position positionTondeuse = tondeuse.getPosition();
        ;
        switch (tondeuse.getOrientation()) {
            case N:
                nouvellePosition.setOrdonnee(positionTondeuse.getOrdonnee() + 1);
                nouvellePosition.setAbscisse(positionTondeuse.getAbscisse());
                break;
            case S:
                nouvellePosition.setOrdonnee(positionTondeuse.getOrdonnee() - 1);
                nouvellePosition.setAbscisse(positionTondeuse.getAbscisse());
                break;
            case E:
                nouvellePosition.setOrdonnee(positionTondeuse.getOrdonnee());
                nouvellePosition.setAbscisse(positionTondeuse.getAbscisse() + 1);
                break;
            case W:
                nouvellePosition.setOrdonnee(positionTondeuse.getOrdonnee());
                nouvellePosition.setAbscisse(positionTondeuse.getAbscisse() - 1);
                break;
        }
        return nouvellePosition;
    }
}
