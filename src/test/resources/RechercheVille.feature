# language: fr

Fonctionnalité: Recherche d'une ville

  Scénario: Une recherche d'une ville existante
    Étant donné que j'entre sur la page de recherche de villes
    Quand j'entre la chaine st-
    Alors je devrais trouver St-Romuald dans les résultats de ville

  Scénario: Une recherche d'une ville inexistante
    Étant donné que j'entre sur la page de recherche de villes
    Quand j'entre la chaine lev
    Alors je ne devrais avoir aucun résultat

  Scénario: Entrer et supprimer du contenu
    Étant donné que j'entre sur la page de recherche de villes
    Quand j'entre la chaine st-
    Et je vide le champ de recherche
    Alors je ne devrais avoir aucun résultat

  Scénario: Afficher les coordonnées
    Étant donné que j'entre sur la page de recherche de villes
    Quand je clique sur le bouton pour afficher les coordonnées
    Alors je devrais voir mes coordonnées apparaître