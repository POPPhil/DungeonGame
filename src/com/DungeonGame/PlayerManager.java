package com.DungeonGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.DungeonGame.Constants.*;
import static com.DungeonGame.GameStatus.*;
import static com.DungeonGame.Printer.*;
import static com.DungeonGame.MonsterManager.*;

public class PlayerManager {
    /**
     * Déplace le joueur sur la carte en mettant à jour les positions et les symboles correspondants.
     *
     * @param map            le tableau 2D représentant la carte.
     * @param playerPosition le tableau d'entiers [row, col] représentant la position actuelle du joueur.
     * @param rowOffset      la valeur de décalage pour la ligne.
     * @param colOffset      la valeur de décalage pour la colonne.
     */
    static void movePlayer(String[][] map, int[] playerPosition, int rowOffset, int colOffset) {
        StringBuilder messageBuilder = new StringBuilder();

        List<int[]> monsterPositions = identifyMonsters(map);
        List<MonsterManager> monsters = new ArrayList<>(); // Déclaration d'une liste de monstres

        for (int[] position : monsterPositions) {
            MonsterManager monster = new MonsterManager(position);
            monsters.add(monster);
            map[position[0]][position[1]] = String.valueOf(MONSTER_SYMBOL);
        }


        int newRow = playerPosition[0] + rowOffset;
        int newCol = playerPosition[1] + colOffset;

        // Vérifier si la nouvelle position est valide dans les limites de la carte
        if (newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length) {
            String newSymbol = map[newRow][newCol];

            if (newSymbol.equals(String.valueOf(Constants.EMPTY_SYMBOL))) {
                // Déplacement sur une case vide
                map[playerPosition[0]][playerPosition[1]] = String.valueOf(EMPTY_SYMBOL);
                playerPosition[0] = newRow;
                playerPosition[1] = newCol;
                map[playerPosition[0]][playerPosition[1]] = String.valueOf(PLAYER_SYMBOL);
            } else if (newSymbol.equals(String.valueOf(MONSTER_SYMBOL))) {
                // Rencontre avec un monstre
                loseLife();
                messageBuilder.append(Constants.MONSTER_ENCOUNTER);
            } else if (newSymbol.equals(String.valueOf(LIFE_SYMBOL))) {
                // Récupération d'une vie supplémentaire
                gainLife();
                map[playerPosition[0]][playerPosition[1]] = String.valueOf(EMPTY_SYMBOL);
                playerPosition[0] = newRow;
                playerPosition[1] = newCol;
                map[playerPosition[0]][playerPosition[1]] = String.valueOf(PLAYER_SYMBOL);
                messageBuilder.append(EXTRA_LIFE_FOUND);
            } else if (newSymbol.equals(String.valueOf(FLAG_SYMBOL))) {
                // Atteinte de l'objectif (drapeau)
                winGame();
            } else {
                messageBuilder.append(INVALID_MOVE);
            }
        } else {
            messageBuilder.append(OUT_OF_BOUNDS);
        }

        // Gérer le déplacement du monstre
        for (MonsterManager monster : monsters) {
            monster.move(map);
        }

        messages = new String[]{messageBuilder.toString().trim()};
        printMap(map, messages);
    }

    /**
     * Trouve une position de départ valide pour le joueur sur la première ligne de la carte.
     * @param map le tableau 2D représentant la carte.
     * @return un tableau d'entiers [row, col] représentant la position de départ du joueur.
     */
    static int[] getStartingPosition(String[][] map) {
        List<Integer> emptyPositions = new ArrayList<>();
        int[] positions = {Constants.X_START, Constants.Y_START};

        // Recherche des positions vides sur la première ligne
        for (int position : positions) {
            if (position >= 0 && position < map[0].length) {
                String symbol = map[0][position];
                if (symbol.equals(String.valueOf(Constants.EMPTY_SYMBOL))) {
                    emptyPositions.add(position);
                }
            }
        }

        if (emptyPositions.isEmpty()) {
            System.err.println("Erreur : Aucune position valide trouvée sur la première ligne.");
            return null;
        }

        // Sélection d'une position aléatoire parmi les positions vides
        Random random = new Random();
        int randomIndex = random.nextInt(emptyPositions.size());
        int selectedPosition = emptyPositions.get(randomIndex);

        return new int[]{0, selectedPosition};
    }
    
    /**
     * Réduit le nombre de vies du joueur et vérifie s'il lui en reste.
     */
    static void loseLife() {
        Constants.lives--;
        if (Constants.lives <= 0) {
            System.out.println(LOSE_ALL_LIFES);
            endGame();
        }
    }

    /**
     * Augmente le nombre de vies du joueur.
     */
    static void gainLife() {
        lives++;
    }

}