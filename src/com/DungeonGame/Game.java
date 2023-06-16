package com.DungeonGame;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static com.DungeonGame.Constants.*;
import static com.DungeonGame.FilesChecker.checkConstantsFile;
import static com.DungeonGame.PlayerManager.*;
import static com.DungeonGame.MonsterManager.identifyMonsters;
import static com.DungeonGame.MessageManager.*;
import static com.DungeonGame.Printer.*;

public class Game {

    /**
     * Lance le jeu en effectuant les étapes suivantes :
     * 1. Charge la carte depuis un fichier.
     * 2. Positionne le joueur et le monstre sur la carte.
     * 3. Affiche la carte et demande les mouvements à l'utilisateur.
     */
    static void playGame() {

        String[] messages = new String[1]; // Variable messages
        String[] errorMessages = new String[1]; // Variable errorMessages
        String[] errorProgramMessages = new String[1]; // Variable errorMessages

        // Condition qui vérifie si le fichier de constantes existe.
        if (!checkConstantsFile()) {
            return;
        }

        // Étape 1 : Charger la carte depuis un fichier
        File mapFile = new File(MAP_FILE);

        if (!mapFile.exists()) {
            setErrorProgramMessage(ERROR_NO_MAP_EXIST, errorProgramMessages);
            return;
        }

        String[][] map = FileReader.readMap(mapFile.getPath());

        if (map == null) {
            setErrorProgramMessage(ERROR_NO_MAP_LOAD, errorProgramMessages);
            return;
        }

        // Étape 2 : Positionner le joueur et le monstre sur la carte
        int[] playerPosition = getStartingPosition(map);
        if (playerPosition == null) {
            setErrorProgramMessage(ERROR_NO_FIRST_POSITION, errorProgramMessages);
            return;
        }

        map[playerPosition[0]][playerPosition[1]] = String.valueOf(PLAYER_SYMBOL);

        List<int[]> monsterPositions = identifyMonsters(map);
        for (int[] position : monsterPositions) {
            map[position[0]][position[1]] = String.valueOf(MONSTER_SYMBOL);
        }

        // Étape 3 : Afficher la carte et demander les mouvements à l'utilisateur
        printLegend();

        printMap(map, messages, errorMessages);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean gameRunning = true;
            while (gameRunning) {
                setMessage(MOVE_LEGEND);

                String input = scanner.nextLine().toUpperCase();

                if (input.isEmpty()) {
                    setErrorMessage(ERROR_NO_INPUT, errorMessages);
                    continue;
                }

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
                        setErrorMessage(ERROR_INVALID_INPUT, errorMessages);
                }

                // clearConsole();
                // if (gameRunning) {
                //     printMap(map, messages, errorMessages);
                // }
            }
        }
    }
}
