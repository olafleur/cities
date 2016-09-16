# language: fr

Fonctionnalité: Bon nom suggéré

  Scénario: Retourne le bon nom suggéré
    Étant donné que j'ai les villes suivantes
      | Amos   |
      | Québec |
      | Lévis   |
    Et que je choisis la chaîne amos
    Alors la ville Amos devrait être suggérée

  Scénario: Gestion des traits
    Étant donné que j'ai les villes suivantes
      | St-Romuald   |
      | St-Apollinaire |
      | St-Pamphile   |
    Et que je choisis la chaîne st-r
    Alors la ville St-Romuald devrait être suggérée
    Et je devrais avoir 1 villes suggérées