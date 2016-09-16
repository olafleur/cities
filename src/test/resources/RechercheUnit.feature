# language: fr

Fonctionnalité: Recherche d'une ville

  Scénario: Avoir le bon nombre de suggestions
    Étant donné que j'ai les villes suivantes
      | Amos   |
      | Québec |
      | Omas   |
    Et que je choisis la chaîne amos
    Alors je devrais avoir 2 villes suggérées