package fr.publicissapient;

import fr.publicissapient.carte.modele.Case;
import fr.publicissapient.carte.service.CarteService;
import fr.publicissapient.deplacement.service.DeplacementService;
import fr.publicissapient.direction.service.DirectionService;
import fr.publicissapient.position.service.PositionService;
import fr.publicissapient.tondeuse.modele.Tondeuse;
import fr.publicissapient.tondeuse.service.TondeuseService;
import fr.publicissapient.utils.CliManager;
import fr.publicissapient.utils.FileReader;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programme {

    private static final Logger logger = Logger.getLogger(Programme.class.getName());

    public static void main(String[] args) throws ParseException {
        String fileName = CliManager.getFileNameFromCommandLine(args);
        List<String> lignes = null;
        try {
            lignes = FileReader.lireFichier(fileName);
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        CarteService carteService = new CarteService();
        TondeuseService tondeuseService = new TondeuseService(new PositionService(), new DirectionService(), new DeplacementService(), carteService);
        Case[][] carte = carteService.construireCarte(lignes);
        List<Tondeuse> tondeuses = tondeuseService.recupererListeTondeuses(lignes);
        tondeuseService.placerTondeusesSurCarte(carte, tondeuses);
        System.out.println(tondeuseService.jouerDeplacementsTondeuses(carte, tondeuses));
    }
}
