# language: fr

Fonctionnalité: Recherche Google

  Scénario: Une recherche Google
    Étant donné que je vais à l'adresse http://google.com
    Quand j'entre le terme de recherche computer science
    Et que je clique sur le bouton de recherche
    Alors je devrais trouver science dans les résultats de recherche

  Scénario: Une recherche qui ne fonctionne pas
    Étant donné que je vais à l'adresse http://google.com
    Quand j'entre le terme de recherche olivier lafleur
    Et que je clique sur le bouton de recherche
    Alors je ne devrais pas trouver fille dans les résultats de recherche