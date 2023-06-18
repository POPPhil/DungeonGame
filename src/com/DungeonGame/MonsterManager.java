package com.DungeonGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.DungeonGame.Constants.*;

public class MonsterManager {
    private int[] position; // Position du monstre sur la carte

    public MonsterManager(int[] position) {
        this.position = position; // Initialise la position du monstre avec la valeur fournie
    }

    public void move(String[][] map) {
        int currentRow = position[0]; // Récupère la ligne actuelle du monstre
        int currentCol = position[1]; // Récupère la colonne actuelle du monstre

        int newRow = currentRow + getRandomOffset(-1, 1); // Calcule une nouvelle ligne aléatoire
        int newCol = currentCol + getRandomOffset(-1, 1); // Calcule une nouvelle colonne aléatoire

        // Vérifie si la nouvelle position est valide dans le rayon de 1 case autour de la position initiale et si la case est vide
        if (isValidPosition(map, newRow, newCol)) {
            updateMap(map, currentRow, currentCol, newRow, newCol); // Met à jour la carte avec la nouvelle position
            updatePosition(newRow, newCol); // Met à jour la position du monstre
        }
    }

    // Génère un décalage aléatoire entre les valeurs min et max incluses
    private int getRandomOffset(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // Vérifie si une position donnée est valide sur la carte
    private boolean isValidPosition(String[][] map, int row, int col) {
        // Vérifie si la position est dans les limites de la carte et si la case est vide
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length && map[row][col].equals(String.valueOf(EMPTY_SYMBOL));
    }

    // Met à jour la carte en remplaçant le symbole de la case actuelle du monstre par le symbole de case vide, tout en mettant le symbole de monstre dans la nouvelle position
    private void updateMap(String[][] map, int currentRow, int currentCol, int newRow, int newCol) {
        map[currentRow][currentCol] = String.valueOf(EMPTY_SYMBOL);
        map[newRow][newCol] = String.valueOf(MONSTER_SYMBOL);
    }

    // Met à jour la position du monstre avec les nouvelles valeurs de ligne et de colonne
    private void updatePosition(int newRow, int newCol) {
        position[0] = newRow;
        position[1] = newCol;
    }

    // Identifie les monstres présents sur la carte et retourne leurs positions
    static List<int[]> identifyMonsters(String[][] map) {
        List<int[]> monsterPositions = new ArrayList<>();

        // Parcourt la carte pour trouver les positions des monstres
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col].equals(String.valueOf(MONSTER_SYMBOL))) {
                    monsterPositions.add(new int[]{row, col});
                }
            }
        }
        return monsterPositions; // Retourne la liste des positions des monstres
    }
}
