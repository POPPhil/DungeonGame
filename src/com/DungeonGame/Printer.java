package com.DungeonGame;

import static com.DungeonGame.Constants.*;

public class Printer {
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
    static void printMessages(String[] messages, String[] errorMessages) {
        for (String message : messages) {
            if (message != null && !message.isEmpty()) {
                System.out.println(message);
            }
        }

        for (String errorMessage : errorMessages) {
            if (errorMessage != null && !errorMessage.isEmpty()) {
                System.err.println(ERROR_PREFIX + errorMessage);
            }
        }
    }

    /**
     * Affiche la légende du jeu avec les règles et les symboles utilisés.
     */
    static void printLegend() {
        System.out.println(LEGEND);
    }
}
