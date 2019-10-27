package main;

import beans.Direction;
import beans.Position;
import beans.Tondeuse;
import exception.InvalidInputException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Programme {
    private static String regexPositionTondeuse = "[0-9]+\\s[0-9]+\\s+[A-Z]{1}";
    private static String regexEspace = "\\s+";
    private static String regexInstructions = "[A-Z]+";

    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String[] args) {
        //Lire le ou les fichiers dans le repertoire cible
        File file = new File(args[0]);
        try {
            List<String> lignes = Files.lines(Paths.get(file.getPath()))
                    .collect(Collectors.toList());
            interpreteLines(lignes);
        } catch (IOException e) {
            System.out.println("Erreur durant la lecture du fichier");
        }
    }

    private static void interpreteLines(List<String> lignes) {
        //premiere ligne coin superieur droit de la pelouse
        String[] taillePelouse = lignes.get(0).split(regexEspace);
        int dimensionPelouseX = Integer.valueOf(taillePelouse[0]);
        int dimensionPelouseY = Integer.valueOf(taillePelouse[1]);
        Tondeuse tondeuse = null;
        //coordonées des tondeuses et instructions de deplacement
        for (int i = 1; i < lignes.size(); i += 2) {
            //la ligne qui contient des espaces est la ligne qui contient les coordonnées de la tondeuse
            pattern = Pattern.compile(regexPositionTondeuse);
            matcher = pattern.matcher(lignes.get(i));
            if (matcher.matches()) {
                String[] coordonnesTondeuse = lignes.get(i).split(regexEspace);
                tondeuse = new Tondeuse(new Position(Integer.valueOf(coordonnesTondeuse[0]), Integer.valueOf(coordonnesTondeuse[1])), Direction.valueOf(coordonnesTondeuse[2]));
                //la ligne d'apres contient les instructions
                String instructions = lignes.get(i + 1);
                pattern = Pattern.compile(regexInstructions);
                matcher = pattern.matcher(instructions);
                if(matcher.matches()) {
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
                    System.out.println(tondeuse.getPosition().getX() + " " + tondeuse.getPosition().getY() + " " + tondeuse.getOrientation().name());
                } else {
                    throw new InvalidInputException("Les instructions de la tondeuse ne sont pas valides");
                }
            } else {
                throw new InvalidInputException("Les coordonnées de la tondeuse ne sont pas valides");
            }
        }
    }

}
