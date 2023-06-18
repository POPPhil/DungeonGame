package com.DungeonGame;

public class Constants {

    // Emplacement des fichiers necessaire au programme
    public static final String MAP_FILE = "data/map.txt";                                                              // Emplacement du fichier map.txt

    // costantes génériques 
    public static final String ERROR_SEPARATION_LINE = "\n\n==============================\n\n";                        // Ligne de sépération
    public static final String ERROR_PREFIX = "Erreur : ";							                                    // Préfixe des messages d'erreur

    // Constantes pour les messages d'erreur du programme
    public static final String ERROR_NO_MAP_EXIST = "Le fichier de carte n'est pas présent dans le dossier /data !";    // Message qui idique que le fichier map.txt est inexistant 
    public static final String ERROR_NO_MAP_LOAD = "La carte n'a pas pu être chargée !";                                // Message qui idique que le fichier map.txt n'est pas chargé
    public static final String ERROR_NO_FIRST_POSITION = "Aucune position valide trouvée sur la première ligne !";      // Message de position sur la première ligne ivalide  

    // Symboles de la carte
    public static final char EMPTY_SYMBOL = ' ';                                                                        // Symbole pour une case vide
    public static final char MONSTER_SYMBOL = 'M';                                                                      // Symbole pour un monstre
    public static final char LIFE_SYMBOL = 'o';                                                                         // Symbole pour une vie supplémentaire
    public static final char FLAG_SYMBOL = 'P';                                                                         // Symbole pour le drapeau (objectif)
    public static final char PLAYER_SYMBOL = 'Y';                                                                       // Symbole pour le joueur

    // Vies du joueur
    public static final int MAX_LIVES = 3;                                                                              // Nombre maximum de vies du joueur
    public static int lives = MAX_LIVES;                                                                                // Vies restantes du joueur

    // Position de départ sur la carte
    public static final int X_START = 14;                                                                               // Position X de départ du joueur
    public static final int Y_START = 15;                                                                               // Position Y de départ du joueur

    // Légende de la carte
    public static final String LEGEND =
        "\n========= Ψ Bienvenue dans Dungeon Game ! Ψ =========\n\n" +
        "Règles du jeu :\n" +
        "- Vous êtes un héros '" + PLAYER_SYMBOL + "' dans un donjon dangereux.\n" +
        "- Trouvez le drapeau '" + FLAG_SYMBOL + "' en parcourant le donjon et en évitant les monstres '" + MONSTER_SYMBOL + "'.\n" +
        "- Vous avez " + MAX_LIVES + " vies au début du jeu. Si vous les perdez, vous mourrez !\n" +
        "- Si vous touchez un monstre '" + MONSTER_SYMBOL + "' vous perdez un point de vie !\n" +
        "- Récupérez des vies '" + LIFE_SYMBOL + "' pour survivre !";                                                   // Légende de la carte

    // Mouvements et actions possibles du joueur
    public static final String MOVE_UP = "Z";                                                                           // Mouvement vers le haut
    public static final String MOVE_DOWN = "S";                                                                         // Mouvement vers le bas
    public static final String MOVE_LEFT = "Q";                                                                         // Mouvement vers la gauche
    public static final String MOVE_RIGHT = "D";                                                                        // Mouvement vers la droite
    public static final String QUIT_GAME = "X";                                                                         // Quitter le jeu

    public static final String MOVE_LEGEND =
            "Utilisez les touches suivantes, (Z: Haut, S: Bas, Q: Gauche, D: Droite, X: Quitter) : ";                   // Légende des mouvements et actions possibles

    // Constantes pour les messages d'info du jeu
    public static final String EXTRA_LIFE_FOUND = "Vous avez trouvé une vie supplémentaire !";                          // Message de vie supplémentaire
    public static final String SEPARATION_LINE = "\n==============================\n";                                  // Ligne de sépération
    public static final String WIN_TEXT = "\n========= Félicitations ! ========" +
            "\n\n" +
            "Vous avez atteint le drapeau et gagné le jeu !";                                                           // Message de victoire
    public static final String END_GAME = "\n=========== Fin du jeu ===========\n";                                     // Message de fin de jeu

    // Constantes pour les messages d'avertissement du jeu
    public static final String WARNING_MONSTER_ENCOUNTER = "Vous avez rencontré un monstre. Vous perdez une vie !";     // Message de rencontre de monstre
    public static final String WARNING_LOSE_ALL_LIVES = "\nVous avez perdu toutes vos vies !";                          // Message de perte de toutes les vies
    public static final String WARNING_INVALID_MOVE = "Vous ne pouvez pas vous déplacer ici !";                         // Message de déplacement non autorisé 
    public static final String WARNING_OUT_OF_BOUNDS = "Vous ne pouvez pas sortir de la carte !";                       // Message de sortie de carte non autorisée
    public static final String WARNING_NO_INPUT = "Aucune entrée détectée !";                                              // Message si aucune entrée n'est détectée dans l'input
    public static final String WARNING_INVALID_INPUT = "Entrée invalide !";                                             // Message d'entrée invalide

    public static final String RED_COLOR;                                                                               // Constante vide pour la couleur rouge
    public static final String GREEN_COLOR;                                                                             // Constante vide pour la couleur verte
    public static final String RESET_COLOR;                                                                             // Constante vide pour réinitialiser la couleur

    // Condifiton qui charge le code pour la gestion de la couleur en fonction de l'OS
    static {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            RED_COLOR = "cmd /c color 0C";                                                                              // Commande Windows pour la couleur rouge
            GREEN_COLOR = "cmd /c color 0A";                                                                            // Commande Windows pour la couleur rouge
            RESET_COLOR = "cmd /c color";                                                                               // Commande Windows pour réinitialiser la couleur
        } else {
            RED_COLOR = "\u001B[31m";                                                                                   // Code ANSI pour la couleur rouge
            GREEN_COLOR = "\u001B[32m";                                                                                 // Code ANSI pour la couleur verte
            RESET_COLOR = "\u001B[0m";                                                                                  // Code ANSI pour réinitialiser la couleur
        }
    }                                                  
}