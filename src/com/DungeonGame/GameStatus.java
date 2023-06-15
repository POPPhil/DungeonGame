package com.DungeonGame;

import static com.DungeonGame.Constants.*;

public class GameStatus {

    /**
     * Affiche un message de victoire et termine le jeu.
     */
    static void winGame() {
        System.out.println(WIN_TEXT);
        endGame();
    }

    /**
     * Affiche un message de fin et termine le jeu.
     */
    static void endGame() {
        System.out.println(END_GAME);
        System.exit(0);
    }
}
