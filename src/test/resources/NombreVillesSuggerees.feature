# language: fr

Fonctionnalité: Nombre de villes suggérées

  Scénario: Retourne deux résultats lorsque similaires
    Étant donné que j'ai les villes suivantes
      | Amos   |
      | Québec |
      | Omas   |
    Et que je choisis la chaîne amos
    Alors je devrais avoir 2 villes suggérées

  Scénario: Retourne un résultat lorsque début identique
    Étant donné que j'ai les villes suivantes
      | Lévis   |
      | Québec |
      | St-Romuald   |
    Et que je choisis la chaîne Lév
    Alors je devrais avoir 1 villes suggérées

  Scénario: Ne gère pas les accents
    Étant donné que j'ai les villes suivantes
      | Lévis   |
      | Québec |
      | St-Romuald   |
    Et que je choisis la chaîne Lev
    Alors je devrais avoir 0 villes suggérées

  Scénario: Gère les majuscules
    Étant donné que j'ai les villes suivantes
      | Lévis   |
      | Québec |
      | St-Romuald   |
    Et que je choisis la chaîne lév
    Alors je devrais avoir 1 villes suggérées