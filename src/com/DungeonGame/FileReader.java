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
        String[][] map = null;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filename))) {
            List<String> lines = new ArrayList<>();
            String line;

            // Lire chaque ligne du fichier
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            int rowCount = lines.size();
            int colCount = lines.get(0).length();

            map = new String[rowCount][colCount];

            // Remplir le tableau de la carte avec les symboles de chaque case
            for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                line = lines.get(rowIndex);
                for (int colIndex = 0; colIndex < colCount; colIndex++) {
                    map[rowIndex][colIndex] = String.valueOf(line.charAt(colIndex));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
