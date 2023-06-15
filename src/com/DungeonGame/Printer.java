package com.DungeonGame;

public class Printer {
    // Affichage de la MAP
    static void printMap(String[][] map, String[] messages) {
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

        printMessages(messages);

        System.out.println(Constants.SEPARATION_LINE);
    }

    // Affichage des messages
    static void printMessages(String[] messages) {
        if (messages.length > 0) {
            for (String message : messages) {
                System.out.println(message);
            }
        }
    }

    /**
     * Affiche la légende du jeu avec les règles et les symboles utilisés.
     */
    static void printLegend() {
        System.out.println(Constants.LEGEND);
    }
}
