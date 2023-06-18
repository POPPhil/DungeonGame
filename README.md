# Dungeon Game

Ce projet est un jeu de donjon en Java. 

Le jeu consiste à déplacer un personnage dans un donjon pour atteindre un drapeau tout en évitant les monstres. Le joueur a un certain nombre de vies et peut gagner ou perdre des vies en fonction de ses actions.

## Règles du jeu

- Le joueur est représenté par le symbole **Y** sur la carte.
- Le drapeau est représenté par le symbole **P** sur la carte. L'objectif du joueur est d'atteindre le drapeau.
- Les monstres sont représentés par le symbole **M** sur la carte, il se déplacent dans une certaine zone et ne peuvent pas en sortir. Si le joueur en touche un, il perd une vie.
- Les vies supplémentaires sont représentées par le symbole **o** sur la carte. Le joueur peu en cumuler autant que possible.
- Le joueur commence avec 3 vies, et perd le jeu s'il les perd toutes.
- Le joueur peut se déplacer dans les quatre directions : Haut (**Z**), Bas (**S**), Gauche (**Q**) et Droite (**D**) *(Validez vos déplacements avec la touche "entrer")*.
- Le joueur peut quitter le jeu à tout moment en appuyant sur la touche **X**.

## Comment exécuter le jeu

1. Assurez-vous d'avoir Java JDK installé sur votre système.
2. Téléchargez les fichiers sources du projet.
3. Compilez le projet en exécutant la commande suivante dans le répertoire du projet :
``javac src/com/DungeonGame/Constants.java src/com/DungeonGame/FileReader.java src/com/DungeonGame/FilesChecker.java src/com/DungeonGame/Game.java src/com/DungeonGame/GameStatus.java src/com/DungeonGame/Main.java src/com/DungeonGame/MessageManager.java src/com/DungeonGame/MonsterManager.java src/com/DungeonGame/PlayerManager.java src/com/DungeonGame/Printer.java``
ou 
``javac src/com/DungeonGame/*``
Selon votre environement.
4. Exécutez le jeu en utilisant la commande suivante :
``java -cp src com.DungeonGame.Main``

## Structure du projet

Le projet est constitué de plusieurs classes d'un fichier data :

- `Constants.java` Il contient la plupart des constantes nécessaires pour l'exécution du jeu.
- `FileReader.java` Il contient des méthodes pour lire les fichiers externes, notamment la carte.
- `FilesChecker.java` Il contient des méthodes pour vérifier si les classes et fichiers sont existants.
- `Game.java`: ce fichier contient la classe principale du jeu. Il comprend des méthodes pour charger la carte, positionner le joueur, effectuer les déplacements du joueur, gérer les vies du joueur et afficher la carte.
- `GameStatus.java` Il contient les éléments de statut du jeu en fonction de l'évolution du joueur.
- `Main.java` Ce fichier est la classe qui exécute le jeu.
- `MessageManager.java`Il contient la gestion des messages.
- `MonsterManager.java` Il contient la gestion des monstres tel que leurs déplacements.
- `PlayerManager.java` Il contient la gestion des déplacements du joueur et les différentes actions lorsqu'il rencontre une situation.
- `Printer.java` Il contient des méthodes piur l'affichage des différents éléments nécessaires au jeu.

- `data/map.txt` = Ce fichier contient la carte du Donjon avec ses différents éléments (monstres, vies et drapeau).

## Dépendances

Ce projet ne dépend d'aucune bibliothèque externe.

## Crédits

Ce projet a été développé par Philippe POP.