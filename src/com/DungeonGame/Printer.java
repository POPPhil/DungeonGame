package com.DungeonGame;

import static com.DungeonGame.Constants.*;
import static com.DungeonGame.MessageManagers.*;

public class Printer {

    /**
     * Affiche les messages d'erreur du programme avant son lancement.
     *
     * @param messageManager l'objet MessageManager contenant les messages d'erreur du programme.
     */
    public static void printErrorProgramMessages(MessageManager messageManager) {
        // Récupérer le message d'erreur du programme depuis le MessageManager
        String errorProgramMessage = messageManager.getErrorProgramMessage();

        // Vérifier si le message d'erreur du programme existe et n'est pas vide
        if (errorProgramMessage != null && !errorProgramMessage.isEmpty()) {
            // Afficher le message d'erreur du programme avec une mise en forme spécifique
            System.err.println(RED_COLOR + ERROR_SEPARATION_LINE + ERROR_PREFIX + errorProgramMessage + ERROR_SEPARATION_LINE + RESET_COLOR);
        }
    }

    /**
     * Affiche la légende du jeu avec les règles et les symboles utilisés.
     */
    static void printLegend() {
        // Afficher la légende du jeu
        System.out.println(LEGEND);
    }

    // Affichage de la MAP
    static void printMap(String[][] map, MessageManager messageManager) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n======= Carte du donjon ======\n\n");

        // Parcourir chaque ligne de la carte et chaque symbole de la ligne
        for (String[] row : map) {
            for (String symbol : row) {
                sb.append(symbol);
            }
            sb.append("\n");
        }

        sb.append("\n====== Vous avez ").append(Constants.lives).append(" vies ======\n");

        // Afficher la carte du donjon
        System.out.println(sb.toString());

        // Afficher les messages du jeu
        printGameMessages(messageManager);

        System.out.println(SEPARATION_LINE);

        System.out.println(MOVE_LEGEND);
    }

    // Affichage des messages et des messages d'avertissement du jeu
    static void printGameMessages(MessageManager messageManager) {
        // Récupérer le message d'information du MessageManager
        String infoMessage = messageManager.getInfoMessage();
        // Vérifier si le message d'information existe et n'est pas vide
        if (infoMessage != null && !infoMessage.isEmpty()) {
            // Afficher le message d'information
            System.out.println(infoMessage);
        }

        // Récupérer le message d'avertissement du MessageManager
        String warningMessage = messageManager.getWarningMessage();
        // Vérifier si le message d'avertissement existe et n'est pas vide
        if (warningMessage != null && !warningMessage.isEmpty()) {
            // Afficher le message d'avertissement en utilisant la couleur rouge pour l'erreur
            System.out.println(RED_COLOR + ERROR_PREFIX + warningMessage + RESET_COLOR);
        }
    }
}
