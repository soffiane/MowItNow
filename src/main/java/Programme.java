import fr.publicissapient.carte.modele.Case;
import fr.publicissapient.carte.service.CarteService;
import fr.publicissapient.tondeuse.modele.Tondeuse;
import fr.publicissapient.tondeuse.service.TondeuseService;
import fr.publicissapient.utils.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Programme {


	public static void main(String[] args) {
		File file = new File(args[0]);
		List<String> lignes = null;
		try {
			lignes = FileReader.lireFichier(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CarteService carteService = new CarteService();
		Case[][] carte = carteService.construireCarte(lignes);
		TondeuseService tondeuseService = new TondeuseService();
		List<Tondeuse> tondeuses = tondeuseService.recupererListeTondeuses(lignes);
		//tondeuseService.placerTondeusesSurCarte(carte, tondeuses);
		//String resultat = tondeuseService.jouerDeplacementsTondeuses(carte, tondeuses);
		tondeuses.forEach(tondeuse -> System.out.println(tondeuse.getPosition().getAbscisse() + " " + tondeuse.getPosition().getOrdonnee() + " " + tondeuse.getOrientation().name()));
	}



    /*private static String interpreteLines(List<String> lignes) {
        //premiere ligne coin superieur droit de la pelouse
        StringBuilder result = new StringBuilder();
        String taillesPelouse = lignes.get(0);
        Pattern pattern = Pattern.compile(Constantes.REGEX_TAILLE_PELOUSE);
        Matcher matcher = pattern.matcher(taillesPelouse);
        if(matcher.matches()) {
            String[] taillePelouse = taillesPelouse.split(Constantes.REGEX_ESPACE);
            int dimensionPelouseX = Integer.parseInt(taillePelouse[0]);
            int dimensionPelouseY = Integer.parseInt(taillePelouse[1]);
            Tondeuse tondeuse = null;
            //coordonées des tondeuses et instructions de deplacement
            for (int i = 1; i < lignes.size(); i += 2) {
                //la ligne qui contient des espaces est la ligne qui contient les coordonnées de la tondeuse
                pattern = Pattern.compile(regexPositionTondeuse);
                matcher = pattern.matcher(lignes.get(i));
                if (matcher.matches()) {
                    String[] coordonnesTondeuse = lignes.get(i).split(regexEspace);
                    tondeuse = new Tondeuse(new Position(Integer.parseInt(coordonnesTondeuse[0]), Integer.parseInt(coordonnesTondeuse[1])), Direction.valueOf(coordonnesTondeuse[2]));
                    //la ligne d'apres contient les instructions
                    String instructions = lignes.get(i + 1);
                    pattern = Pattern.compile(regexInstructions);
                    matcher = pattern.matcher(instructions);
                    if (matcher.matches()) {
                        for (char c : instructions.toCharArray()) {
                            switch (c) {
                                case 'A':
                                    tondeuse.deplacer(dimensionPelouseX, dimensionPelouseY);
                                    break;
                                case 'D':
                                    tondeuse.tournerADroite();
                                    break;
                                case 'G':
                                    tondeuse.tournerAGauche();
                                    break;
                                default:
                                    throw new InvalidInputException("Commande invalide " + c);
                            }
                        }
                        result.append(tondeuse.getPosition().getAbscisse() + " " + tondeuse.getPosition().getOrdonnee() + " " + tondeuse.getOrientation().name());
                        if(i < lignes.size() - 2) {
                            result.append(System.getProperty("line.separator"));
                        }
                    } else {
                        throw new InvalidInputException("Les instructions de la tondeuse ne sont pas valides");
                    }
                } else {
                    throw new InvalidInputException("Les coordonnées de la tondeuse ne sont pas valides");
                }
            }
        } else {
            throw new InvalidInputException("La taille de la pelouse n'est pas valide");
        }
        return result.toString();
    }*/

}
