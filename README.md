PublicisSapient : Exercice pratique - Mow it now
Ce projet est une réponse àà un exercice technique demandé par PublicisSapient.

Lancer le projet
Pour lancer le projet, cloner ou télécharger l'archive de ce repo.
Se rendre dans le dossier du projet et lancer la commande mvn clean install
Aller dans le dossier target et lancer le jar (il est impératif de fournir un fichier d'entrée à lire):
Si je souhaite que le fichier de sortie soit créé dans le dossier target :
java -jar tondeuse-jar-with-dependencies.jar -fileInput "input_file.txt"
On peut aussi tout simplement passer par son IDE favoris. Par exemple Intellij ou Eclipse

Environnement technique
Java 8
Maven 3
Apache Common CLI
Intellij Idea