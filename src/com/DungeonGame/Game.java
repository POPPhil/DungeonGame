package com.DungeonGame;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static com.DungeonGame.Constants.*;
import static com.DungeonGame.FilesChecker.checkClassFiles;
import static com.DungeonGame.PlayerManager.*;
import static com.DungeonGame.MonsterManager.identifyMonsters;
import static com.DungeonGame.MessageManager.*;
import static com.DungeonGame.Printer.*;

public class Game {

    private static MessageManager messageManager = new MessageManager();

    /**
     * Lance le jeu en effectuant les étapes suivantes :
     * 1. Charge la carte depuis un fichier.
     * 2. Positionne le joueur et le monstre sur la carte.
     * 3. Affiche la carte et demande les mouvements à l'utilisateur.
     */
    static void playGame() {

        // Condition qui vérifie si les fichiers de constantes existe.
        if (!checkClassFiles()) {
            return;
        }

        // Étape 1 : Charger la carte depuis un fichier
        File mapFile = new File(MAP_FILE);

        if (!mapFile.exists()) {
            messageManager.setErrorProgramMessage(ERROR_NO_MAP_EXIST);
            return;
        }

        String[][] map = FileReader.readMap(mapFile.getPath());

        if (map == null) {
            messageManager.setErrorProgramMessage(ERROR_NO_MAP_LOAD);
            return;
        }

        // Étape 2 : Positionner le joueur et le monstre sur la carte
        int[] playerPosition = getStartingPosition(map);
        if (playerPosition == null) {
            messageManager.setErrorProgramMessage(ERROR_NO_FIRST_POSITION);
            return;
        }

        map[playerPosition[0]][playerPosition[1]] = String.valueOf(PLAYER_SYMBOL);

        List<int[]> monsterPositions = identifyMonsters(map);
        for (int[] position : monsterPositions) {
            map[position[0]][position[1]] = String.valueOf(MONSTER_SYMBOL);
        }

        // Étape 3 : Afficher la carte et demander les mouvements à l'utilisateur
        printLegend();

        printMap(map, messageManager);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean gameRunning = true;
            while (gameRunning) {

                String input = scanner.nextLine().toUpperCase();

                if (input.isEmpty()) {
                    messageManager.setWarningMessage(WARNING_NO_INPUT);
                    continue;
                }

                switch (input) {
                    case MOVE_UP:
                        movePlayer(map, playerPosition, -1, 0);
                        break;
                    case MOVE_DOWN:
                        movePlayer(map, playerPosition, 1, 0);
                        break;
                    case MOVE_LEFT:
                        movePlayer(map, playerPosition, 0, -1);
                        break;
                    case MOVE_RIGHT:
                        movePlayer(map, playerPosition, 0, 1);
                        break;
                    case QUIT_GAME:
                        gameRunning = false;
                        break;
                    default:
                        messageManager.setWarningMessage(WARNING_INVALID_INPUT);
                }

                // clearConsole();
                // if (gameRunning) {
                //     printMap(map, messages, warningMessages);
                // }
            }
        }
    }
}
