package com.DungeonGame;

import java.io.IOException;
import java.io.InputStream;

public class FilesChecker {

    /**
     * Vérifie si les fichiers de classes .java sont existants
     */
    static boolean checkClassFiles() {
        String packageDirectory = "/com/DungeonGame"; // Répertoire du package contenant les fichiers de classes

        String[] classNames = {"Constants", "FileReader", "Game", "GameStatus", "MessageManager", "MonsterManager", "PlayerManager", "Printer"}; // Liste des noms des classes à vérifier

        for (String className : classNames) {
            String classFilePath = packageDirectory + "/" + className + ".class"; // Chemin du fichier de classe

            // Ouvre le fichier de classe en tant que flux d'entrée
            InputStream inputStream = FilesChecker.class.getResourceAsStream(classFilePath);

            if (inputStream == null) {
                // Si le flux d'entrée est null, cela signifie que le fichier de classe n'existe pas
                System.err.println("\n\nErreur : La classe '" + className + "' est manquante.\n\nLe programme ne peut pas s'exécuter !\n\n");
                return false; // Retourne false pour indiquer que les fichiers de classe sont manquants
            } else {
                // Si le flux d'entrée est ouvert, le fichier de classe existe
                try {
                    inputStream.close(); // Ferme le flux d'entrée
                } catch (IOException e) {
                    e.printStackTrace(); // En cas d'erreur lors de la fermeture du flux d'entrée, afficher la trace de l'exception
                }
            }
        }

        return true; // Retourne true pour indiquer que tous les fichiers de classe existent
    }
}
