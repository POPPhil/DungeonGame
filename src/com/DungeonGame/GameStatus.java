package com.DungeonGame;

import static com.DungeonGame.Constants.*;

public class GameStatus {

    /**
     * Affiche un message de victoire et termine le jeu.
     */
    static void winGame() {
        System.out.println(GREEN_COLOR + WIN_TEXT + RESET_COLOR);
        endGame();
    }

    /**
     * Affiche un message de fin et termine le jeu.
     */
    static void endGame() {
        System.out.println(RED_COLOR + END_GAME + RESET_COLOR);
        System.exit(0);
    }
}
