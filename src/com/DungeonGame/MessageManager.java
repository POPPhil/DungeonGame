package com.DungeonGame;

public class MessageManager {

    private String errorProgramMessage; // Variable pour stocker le message d'erreur du programme
    private String infoMessage; // Variable pour stocker le message d'information du jeu
    private String warningMessage; // Variable pour stocker le message d'avertissement du jeu

    /**
     * Obtient le message d'erreur du programme.
     *
     * @return Le message d'erreur du programme.
     */
    public String getErrorProgramMessage() {
        return errorProgramMessage != null ? errorProgramMessage : ""; // Renvoie le message d'erreur du programme s'il existe, sinon renvoie une chaîne vide
    }

    /**
     * Obtient le message d'information du jeu.
     *
     * @return Le message d'information du jeu.
     */
    public String getInfoMessage() {
        return infoMessage != null ? infoMessage : ""; // Renvoie le message d'information s'il existe, sinon renvoie une chaîne vide
    }

    /**
     * Obtient le message d'avertissement du jeu.
     *
     * @return Le message d'avertissement du jeu.
     */
    public String getWarningMessage() {
        return warningMessage != null ? warningMessage : ""; // Renvoie le message d'avertissement du jeu s'il existe, sinon renvoie une chaîne vide
    }

    /**
     * Définit le message d'erreur du programme.
     *
     * @param errorProgramMessage Le message d'erreur du programme.
     */
    public void setErrorProgramMessage(String errorProgramMessage) {
        this.errorProgramMessage = errorProgramMessage; // Définit le message d'erreur du programme avec la valeur spécifiée
    }

    /**
     * Définit le message d'information du jeu.
     *
     * @param infoMessage Le message d'information du jeu.
     */
    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage; // Définit le message d'information du jeu avec la valeur spécifiée
    }

    /**
     * Définit le message d'avertissement du jeu.
     *
     * @param warningMessage Le message d'avertissement du jeu.
     */
    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage; // Définit le message d'avertissement du jeu avec la valeur spécifiée
    }
}