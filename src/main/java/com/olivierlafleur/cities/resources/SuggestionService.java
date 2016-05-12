package com.olivierlafleur.cities.resources;

import com.olivierlafleur.cities.model.Suggestion;
import com.olivierlafleur.cities.repository.Repository;
import com.olivierlafleur.cities.util.CityToSuggestion;
import com.olivierlafleur.cities.util.LevenshteinDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuggestionService {
    private final Repository repository;

    public SuggestionService(Repository repository) {
        this.repository = repository;
    }

    public List<Suggestion> retrieveSuggestions(String query, double latitude, double longitude) {
        List<Suggestion> suggestions = new ArrayList<>();

        suggestions.add(new Suggestion("Amos", 30, 70, 0.5));

        return suggestions;
    }

    public List<Suggestion> retrieveSuggestions(String query) {
        return repository.getAllCities()
                .stream()
                .filter(x -> LevenshteinDistance.compute(x.getName().toLowerCase(), query.toLowerCase()) <= 2)
                .map(x -> CityToSuggestion.map(x, 1.0))
                .collect(Collectors.toList());
    }
}
