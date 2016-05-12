package com.olivierlafleur.cities.resources;

import com.olivierlafleur.cities.model.Suggestion;

import java.util.ArrayList;
import java.util.List;

public class SuggestionService {
    public List<Suggestion> retrieveSuggestions(String query, double latitude, double longitude) {
        List<Suggestion> suggestions = new ArrayList<Suggestion>();

        suggestions.add(new Suggestion("Amos", 30, 70, 0.5));

        return suggestions;
    }

    public List<Suggestion> retrieveSuggestions(String query) {
        List<Suggestion> suggestions = new ArrayList<Suggestion>();

        suggestions.add(new Suggestion("Amos", 30, 70, 0.5));

        return suggestions;
    }
}
