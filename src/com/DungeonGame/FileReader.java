package com.DungeonGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    /**
     * Charge la carte à partir d'un fichier.
     * @param filename le nom du fichier contenant la carte.
     * @return un tableau 2D représentant la carte.
     */
    static String[][] readMap(String filename) {
        String[][] map = null; // Déclaration du tableau de la carte, initialisé à null

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filename))) {
            // Création d'un BufferedReader pour lire le fichier
            // Le try-with-resources est utilisé pour s'assurer que le BufferedReader est correctement fermé

            List<String> lines = new ArrayList<>(); // Création d'une liste pour stocker les lignes du fichier
            String line;

            // Lis chaque ligne du fichier
            while ((line = reader.readLine()) != null) {
                lines.add(line); // Ajouter la ligne à la liste
            }

            int rowCount = lines.size(); // Nombre de lignes de la carte (taille de la liste)
            int colCount = lines.get(0).length(); // Nombre de colonnes de la carte (longueur de la première ligne)

            map = new String[rowCount][colCount]; // Création du tableau de la carte avec les dimensions appropriées

            // Remplis le tableau de la carte avec les symboles de chaque case
            for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                line = lines.get(rowIndex); // Récupére la ligne correspondante
                for (int colIndex = 0; colIndex < colCount; colIndex++) {
                    map[rowIndex][colIndex] = String.valueOf(line.charAt(colIndex)); // Récupére le symbole de chaque case et le stocke dans le tableau
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // En cas d'erreur lors de la lecture du fichier, afficher la trace de l'exception
        }

        return map; // Retourne le tableau de la carte
    }
}
