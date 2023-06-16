package com.DungeonGame;

import static com.DungeonGame.Constants.*;
import static com.DungeonGame.Printer.*;

public class MessageManager {

    StringBuilder messageBuilder = new StringBuilder();

    // Charge les messages d'erreur du programme
    public static void setErrorProgramMessage(String errorProgramMessage, String[] errorProgramMessages) {
        System.err.println(ERROR_SEPARATION_LINE + ERROR_PREFIX + errorProgramMessage + ERROR_SEPARATION_LINE);
        errorProgramMessages[0] = errorProgramMessage;
    }

    // Charge les messages d'erreur du jeu
    public static void setErrorMessage(String errorMessages, String[] messages) {
        messages[0] = errorMessages;
        printErrorMessage(ERROR_SEPARATION_LINE + ERROR_PREFIX + errorMessages + ERROR_SEPARATION_LINE);
    }

    // Charge les messages d'info du jeu
    public static void setMessage(String messages) {
        System.err.println(messages);
    }
}
