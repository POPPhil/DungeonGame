package com.DungeonGame;

import java.io.IOException;

import static com.DungeonGame.Constants.*;

public class Printer {

    /**
     * Efface l'écran de la console.
     */
    /* public static void clearConsole() {
        try {
            // Obtient le nom du système d'exploitation
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Pour Windows, exécute la commande "cls" pour effacer l'écran
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Pour les autres systèmes d'exploitation (Linux, macOS, etc.), utilise le code ANSI pour effacer l'écran
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            // Affiche la trace d'erreur en cas d'exception
            e.printStackTrace();
        }
    } */

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
            System.err.println(RED_COLOR +ERROR_SEPARATION_LINE + ERROR_PREFIX + errorProgramMessage + ERROR_SEPARATION_LINE + RESET_COLOR);
        }
    }

    /**
     * Affiche la légende du jeu avec les règles et les symboles utilisés.
     */
    static void printLegend() {
        // Afficher la légende du jeu
        System.out.println(LEGEND);
    }

    /**
     * Affiche la carte du donjon.
     *
     * @param map            la carte du donjon représentée par une matrice de chaînes de caractères.
     * @param messageManager l'objet MessageManager contenant les messages du jeu.
     */
    static void printMap(String[][] map, MessageManager messageManager) {

        // Effacer le contenu de la carte
        // clearConsole();

        // Constructeur StringBuilder pour gérer l'affichage de la carte
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

        // Afficher une ligne de séparation
        System.out.println(SEPARATION_LINE);

        // Afficher la légende de déplacement du jeu
        System.out.println(MOVE_LEGEND);
    }

    /**
     * Affiche les messages et les messages d'avertissement du jeu.
     *
     * @param messageManager l'objet MessageManager contenant les messages du jeu.
     */
    static void printGameMessages(MessageManager messageManager) {
        // Récupérer le message d'information du MessageManager
        String infoMessage = messageManager.getInfoMessage();
        // Récupérer le message d'avertissement du MessageManager
        String warningMessage = messageManager.getWarningMessage();

        // Vérifier si le message d'information existe et n'est pas vide
        if (infoMessage != null && !infoMessage.isEmpty()) {
            // Afficher le message d'information
            System.out.println(GREEN_COLOR + infoMessage + RESET_COLOR);
            // Réinitialiser le message d'information à vide
            messageManager.setInfoMessage("");
        }

        // Vérifier si le message d'avertissement existe et n'est pas vide
        if (warningMessage != null && !warningMessage.isEmpty()) {
            // Afficher le message d'avertissement en utilisant la couleur rouge pour l'erreur
            System.out.println(RED_COLOR + ERROR_PREFIX + warningMessage + RESET_COLOR);
            // Réinitialiser le message d'avertissement à vide
            messageManager.setWarningMessage("");
        }
    }
}

