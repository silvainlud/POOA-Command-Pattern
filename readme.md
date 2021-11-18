## Simon HEBAN & Ludwig SILVAIN- M1 WedSci

# Programmation orienté objet Avancée (M1) : Command Pattern

## Introduction

Le design pattern Command fait partie de la catégorie des patterns de comportements. Il permet d’encapsuler les commandes afin de garder un historique et de revenir à une version antérieure. Cette encapsulation comporte deux méthodes, “execute” et “unexecute”, la première permettant d'exécuter la commande souhaitée et la deuxième permettant de revenir en arrière (rollback).

Ce design pattern répond donc à un problème de sauvegarde de données lors de modifications délicates, telles que les transactions SQL: si une transaction échoue toutes les requêtes faites depuis le début sont annulées (rollback). On peut aussi retrouver l’utilité de ce patron dans les historiques de logiciels, par exemple Photoshop qui permet de revenir en arrière.

La mise en œuvre reste assez simple. Une classe dit invoqueur (Invoker) qui exécutera la commande, une interface qui représente de façon générale les commandes (ICommand) ensuite une classe qui implémente cette interface (Command), avec dans son constructeur l’objet ciblé nommé receveur (receiver).
Le plus grand avantage de ce patron est de pouvoir encapsuler la commande permettant par la suite d’avoir un historique et une sauvegarde des différents états. Le plus grand problème de ce design pattern est la lisibilité, en effet plus on a de commandes plus on aura de fichiers, d’associations, le code va augmenter assez rapidement.

## Explication

![](images/Schema%20Explication.png)

Ce diagramme est composé de trois classes et une interface.
- Invoker:
L’invoker sera la classe qui invoquera la commande, pour ce fait elle aura besoin de connaître au préalable la cible (le receiver). Cette classe pourra avoir une propriété de type file permettant d’exécuter une multitude de commandes. Elle pourra aussi avoir une pile permettant de garder un historique des commandes faites. On pourra ainsi exécuter les commandes dans la file, ou bien annuler les commandes dans la pile.
ICommand:
L’interface “ICommand” qui permet de généraliser les commandes, on pourra avoir plusieurs types de commandes.

- Command:
Classe qui implémente ICommand, permet d’avoir une multitude de commandes. Elle possède par défaut deux méthodes: “execute” et (“rollback” ou “unexecute”).

- Receiver:
La classe “receiver” et la classe qui recevra la commande. C’est sur cette classe que l’action se passera.

- Client:
La classe qui appelle l’invoqueur, elle doit préalablement connaître le receveur ainsi que la/les commandes à exécuter.

## Exemple

![](images/Schema%20Exemple.png)

#### `ISqlRequest.java` _(ICommand)_
![](images/ISqlRequest.png)

### `SqlTransaction.java` _(Invoker)_
![](images/SqlTransaction.png)

### `SqlServer.java` _(Receiver)_
![](images/SqlServer.png)

### `DeleteSqlRequest.java` _(Command)_
![](images/DeleteSqlRequest.png)

### `UpdateSqlRequest.java` _(Command)_
![](images/UpdateSqlRequest.png)

### `SqlClient.java` _(Client)_
![](images/SqlClient.png)


