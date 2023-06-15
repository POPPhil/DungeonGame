package com.DungeonGame;

public class FilesChecker {

    /**
     * Verifie si Constants.java est existant
     */
    static boolean checkConstantsFile() {
        try {
            Class.forName("com.DungeonGame.Constants");
            return true;
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : La classe Constants est manquante.");
            return false;
        }
    }
}
