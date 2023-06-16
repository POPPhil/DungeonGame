package com.DungeonGame;

import static com.DungeonGame.Constants.*;

public class Printer {

    /**
     * Affiche les erreurs avant le lancement du programme.
     */
    public static void printErrorMessage(String errorProgramMessages) {
        System.err.println(RED_COLOR + errorProgramMessages + RESET_COLOR);
    }

    /**
     * Affiche la légende du jeu avec les règles et les symboles utilisés.
     */
    static void printLegend() {
        System.out.println(LEGEND);
    }

    // Affichage de la MAP
    static void printMap(String[][] map, String[] messages, String[] errorMessages) {

        StringBuilder sb = new StringBuilder();

        sb.append("\n======= Carte du donjon ======\n\n");

        for (String[] row : map) {
            for (String symbol : row) {
                sb.append(symbol);
            }
            sb.append("\n");
        }

        sb.append("\n====== Vous avez ").append(Constants.lives).append(" vies ======\n");

        System.out.println(sb.toString());

        printMessages(messages, errorMessages);

        System.out.println(SEPARATION_LINE);
    }

    // Affichage des messages et des messages d'erreur
    static void printMessages(String[] infoMessages, String[] errorMessages) {

        for (String infoMessage : infoMessages) {
            if (infoMessage != null && !infoMessage.isEmpty()) {
                System.out.println(infoMessage);
            }
        }

        for (int i = 0; i < errorMessages.length; i++) {
            String errorMessage = errorMessages[i];
            if (errorMessage != null && !errorMessage.isEmpty()) {
                printErrorMessage(RED_COLOR + ERROR_PREFIX + errorMessage + RESET_COLOR);
            }
        }
    }

}
