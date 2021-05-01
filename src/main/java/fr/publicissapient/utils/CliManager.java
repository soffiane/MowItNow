package fr.publicissapient.utils;

import org.apache.commons.cli.*;

public class CliManager {
    public static String getFileNameFromCommandLine(String[] args) throws ParseException {

        Options options = new Options();
        Option input = new Option("fileInput", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);
        CommandLine commandLine = parseArguments(options, args);
        return commandLine.getOptionValue("fileInput");
    }


    public static CommandLine parseArguments(Options options, String[] args) throws ParseException {

        CommandLineParser commandLineParser = new DefaultParser();
        HelpFormatter helpFormatter = new HelpFormatter();

        try {
            return commandLineParser.parse(options, args);
        } catch (ParseException pe) {
            helpFormatter.printHelp("java", options);
            System.out.println("############### /!\\ ###############");
            System.out.println("Impossible de récupérer les arguments depuis la commande de lancement du programme. Arrêt du programe en cours !");
            System.out.println("Pour plus d'informations, regarder la suite de la console du programme.");
            System.out.println("############### /!\\ ###############");
            pe.printStackTrace();
            System.exit(0);
            throw new ParseException(pe.getMessage());
        }
    }

    public static String getArgumentValue(CommandLine commandLine, String argName) {
        return commandLine.getOptionValue(argName);
    }
}
