# Projet JAVA Spring

Ce projet est constitué d'une API REST réalisée à l'aide du framework Java Spring.
Il utilise une base de données en PostgreSQL intégrée dans un environnement Docker.

Un PGAdmin est également disponible pour accéder manuellement à la base de données si besoin.

### Prérequis :
- Docker
- Docker Compose

## Lancement des containers Docker

```shell
cd java-crud-api
docker compose up -d
```

## Accès à PGAdmin

Aller sur `localhost:5050`

Identifiants PGAdmin (définis dans le fichier docker-compose.yml) :
- Email : `user@email.com`
- Mot de passe : `password`

Cliquer ensuite sur l'onglet "Dashboard" et cliquer sur "Add New Server", renseigner les informations suivantes :
- General --> Name : `java-crud-api` ou autre chose
- Connection --> Host name/address : `database` (obligatoire)
- Connection --> Port : `5432`
- Connection --> Username : `user`
- Connection --> Password : `password`

Un nouveau serveur appelé `java-crud-api` devrait être apparu dans la liste à gauche.

Pour ensuite voir les tables, aller dans : `java-crud-api/Databases/mobility/Schemas/public/Tables`.

Faites ensuite un clique droit puis "View/Edit data --> All rows" et vous pouver interagir avec les données de la table que vous avez sélectionnée.

## Lancement de l'application Java

Dans IntelliJ, assurez vous que le fichier `JavaCrudApiApplication`
est sélectionné dans la barre de Configuration en haut à droite (normalement il est détecté automatiquement).
Cliquer ensuite sur le bouton Run.
L'application tourne désormais sur le port `8080`.