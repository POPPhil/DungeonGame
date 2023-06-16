package com.DungeonGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FilesChecker {

    /**
     * Vérifie si les fichiers de classes .java sont existants
     */
    static boolean checkClassFiles() {
        String packageDirectory = "/com/DungeonGame";

        String[] classNames = {"Constants", "FileReader", "Game", "GameStatus", "MessageManager", "MonsterManager", "PlayerManager", "Printer"};    // Liste des package a verifier

        for (String className : classNames) {
            String classFilePath = packageDirectory + "/" + className + ".class";
            InputStream inputStream = FilesChecker.class.getResourceAsStream(classFilePath);
            if (inputStream == null) {
                System.err.println("\n\nErreur : La classe '" + className + "' est manquante.\n\nLe programme ne peut pas s'exécuter !\n\n");
                return false;
            } else {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }
}
