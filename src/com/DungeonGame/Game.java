package com.DungeonGame;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static com.DungeonGame.Constants.*;
import static com.DungeonGame.FilesChecker.checkClassFiles;
import static com.DungeonGame.PlayerManager.*;
import static com.DungeonGame.MonsterManager.identifyMonsters;
import static com.DungeonGame.Printer.*;

public class Game {

    // Gestionnaire de messages pour afficher les messages du jeu
    private static MessageManager messageManager = new MessageManager();

    /**
     * Lance le jeu en effectuant les étapes suivantes :
     * 1. Charge la carte depuis un fichier.
     * 2. Positionne le joueur et le monstre sur la carte.
     * 3. Affiche la carte et demande les mouvements à l'utilisateur.
     */
    static void playGame() {

        // Condition qui vérifie si les fichiers de constantes existent.
        if (!checkClassFiles()) {
            return; // Arrête le jeu si les fichiers de constantes sont manquants
        }

        // Étape 1 : Charger la carte depuis un fichier
        File mapFile = new File(MAP_FILE);

        // Condition qui vérifie si le fichier map.txt existe.
        if (!mapFile.exists()) {
            messageManager.setErrorProgramMessage(ERROR_NO_MAP_EXIST);
            return; // Arrête le jeu si le fichier de la carte n'existe pas
        }

        String[][] map = FileReader.readMap(mapFile.getPath());

        // Condition qui vérifie si le fichier map.txt peu être chargée.
        if (map == null) {
            messageManager.setErrorProgramMessage(ERROR_NO_MAP_LOAD);
            return; // Arrête le jeu si la carte ne peut pas être chargée
        }

        // Étape 2 : Positionner le joueur et le monstre sur la carte
        int[] playerPosition = getStartingPosition(map);
        // Condition qui vérifie si la position de départ du joueur est valide.
        if (playerPosition == null) {
            messageManager.setErrorProgramMessage(ERROR_NO_FIRST_POSITION);
            return; // Arrête le jeu si la position de départ du joueur n'est pas trouvée
        }

        map[playerPosition[0]][playerPosition[1]] = String.valueOf(PLAYER_SYMBOL);

        List<int[]> monsterPositions = identifyMonsters(map);
        for (int[] position : monsterPositions) {
            map[position[0]][position[1]] = String.valueOf(MONSTER_SYMBOL);
        }

        // Étape 3 : Afficher la carte et demander les mouvements à l'utilisateur
        printLegend(); // Affiche la légende du jeu

        printMap(map, messageManager); // Affiche la carte et les messages du jeu

        try (Scanner scanner = new Scanner(System.in)) {
            boolean gameRunning = true;
            while (gameRunning) {

                String input = scanner.nextLine().toUpperCase();

                if (input.isEmpty()) {
                    messageManager.setWarningMessage(WARNING_NO_INPUT); // Affiche un message si l'entrée est vide
                    printMap(map, messageManager);
                    continue; // Ignore les mouvements invalides ou vides
                }

                switch (input) {
                    case MOVE_UP:
                        movePlayer(map, playerPosition, -1, 0);
                        break; // Déplace le joueur en haut si l'utilisateur valide la touche Z
                    case MOVE_DOWN:
                        movePlayer(map, playerPosition, 1, 0);
                        break; // Déplace le joueur en bas si l'utilisateur valide la touche S
                    case MOVE_LEFT:
                        movePlayer(map, playerPosition, 0, -1);
                        break; // Déplace le joueur à gauche si l'utilisateur valide la touche Q
                    case MOVE_RIGHT:
                        movePlayer(map, playerPosition, 0, 1);
                        break; // Déplace le joueur à droite si l'utilisateur valide la touche D
                    case QUIT_GAME:
                        gameRunning = false;
                        break; // Arrête le jeu si l'utilisateur valide la touche X
                    default:
                        messageManager.setWarningMessage(WARNING_INVALID_INPUT); // Affiche un message si l'entrée n'est pas celle attendue
                        printMap(map, messageManager);
                }
            }
        }
    }
}
