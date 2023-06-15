package com.DungeonGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.DungeonGame.Constants.EMPTY_SYMBOL;
import static com.DungeonGame.Constants.MONSTER_SYMBOL;

public class MonsterManager {
    private int[] position;

    public MonsterManager(int[] position) {
        this.position = position;
    }

    public void move(String[][] map) {
        int currentRow = position[0];
        int currentCol = position[1];

        int newRow = currentRow + getRandomOffset(-1, 1);
        int newCol = currentCol + getRandomOffset(-1, 1);

        // Vérifier si la nouvelle position est valide dans le rayon de 1 case autour de la position initiale et si la case est vide
        if (isValidPosition(map, newRow, newCol)) {
            updateMap(map, currentRow, currentCol, newRow, newCol);
            updatePosition(newRow, newCol);
        }
    }

    private int getRandomOffset(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private boolean isValidPosition(String[][] map, int row, int col) {
        // Vérifier si la position est dans les limites de la carte et si la case est vide
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length && map[row][col].equals(String.valueOf(EMPTY_SYMBOL));
    }
    private void updateMap(String[][] map, int currentRow, int currentCol, int newRow, int newCol) {
        map[currentRow][currentCol] = String.valueOf(EMPTY_SYMBOL);
        map[newRow][newCol] = String.valueOf(MONSTER_SYMBOL);
    }

    private void updatePosition(int newRow, int newCol) {
        position[0] = newRow;
        position[1] = newCol;
    }

    // Identifie les monstres
    static List<int[]> identifyMonsters(String[][] map) {
        List<int[]> monsterPositions = new ArrayList<>();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col].equals(String.valueOf(MONSTER_SYMBOL))) {
                    monsterPositions.add(new int[]{row, col});
                }
            }
        }
        return monsterPositions;
    }
}
