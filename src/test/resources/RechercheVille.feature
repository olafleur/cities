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