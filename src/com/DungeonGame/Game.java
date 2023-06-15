package com.DungeonGame;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static com.DungeonGame.Constants.*;
import static com.DungeonGame.FilesChecker.checkConstantsFile;
import static com.DungeonGame.PlayerManager.*;
import static com.DungeonGame.MonsterManager.identifyMonsters;
import static com.DungeonGame.Printer.*;

public class Game {

    /**
     * Lance le jeu en effectuant les étapes suivantes :
     * 1. Charge la carte depuis un fichier.
     * 2. Positionne le joueur et le monstre sur la carte.
     * 3. Affiche la carte et demande les mouvements à l'utilisateur.
     */
    static void playGame() {

        // Condition qui verifie si le fichier de constant existe.
        if (!checkConstantsFile()) {
            return;
        }

        // Étape 1 : Charger la carte depuis un fichier
        File mapFile = new File(MAP_FILE);

        if (!mapFile.exists()) {
            System.err.println("Erreur : Le fichier de carte n'est pas présent dans le dossier /data.");
            return;
        }

        String[][] map = FileReader.readMap(mapFile.getPath());

        if (map == null) {
            System.err.println("Erreur : La carte n'a pas pu être chargée.");
            return;
        }

        // Étape 2 : Positionner le joueur et le monstre sur la carte
        int[] playerPosition = getStartingPosition(map);
        if (playerPosition == null) {
            System.err.println("Erreur : Impossible de trouver une position valide pour le personnage sur la première ligne.");
            return;
        }
        map[playerPosition[0]][playerPosition[1]] = String.valueOf(PLAYER_SYMBOL);

        List<int[]> monsterPositions = identifyMonsters(map);
        //List<Monster> monsters = new ArrayList<>(); // Ajout de la déclaration de la variable "monsters"
        for (int[] position : monsterPositions) {
            //Monster monster = new Monster(position);
            // monsters.add(monster);
            map[position[0]][position[1]] = String.valueOf(MONSTER_SYMBOL);
        }

        // Étape 3 : Afficher la carte et demander les mouvements à l'utilisateur
        printLegend();

        printMap(map, messages);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean gameRunning = true;
            while (gameRunning) {

                System.out.print(MOVE_LEGEND);

                String input = scanner.nextLine().toUpperCase();

                switch (input) {
                    case Constants.MOVE_UP:
                        movePlayer(map, playerPosition, -1, 0);
                        break;
                    case Constants.MOVE_DOWN:
                        movePlayer(map, playerPosition, 1, 0);
                        break;
                    case Constants.MOVE_LEFT:
                        movePlayer(map, playerPosition, 0, -1);
                        break;
                    case Constants.MOVE_RIGHT:
                        movePlayer(map, playerPosition, 0, 1);
                        break;
                    case Constants.QUIT_GAME:
                        gameRunning = false;
                        break;
                    default:

                        messages[0] = INVALID_INPUT;

                }

                // clearConsole();
                if (gameRunning) {

                    printMap(map, messages);

                }
            }
        }
    }
}