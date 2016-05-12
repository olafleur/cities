package com.olivierlafleur.cities.resources;

import com.olivierlafleur.cities.model.City;
import com.olivierlafleur.cities.model.Suggestion;
import com.olivierlafleur.cities.repository.Repository;
import com.olivierlafleur.cities.util.CityToSuggestion;
import com.olivierlafleur.cities.util.HaversineDistance;
import com.olivierlafleur.cities.util.LevenshteinDistance;

import java.util.ArrayList;
import java.util.List;

public class SuggestionService {
    private final Repository repository;

    public SuggestionService(Repository repository) {
        this.repository = repository;
    }

    public List<Suggestion> retrieveSuggestions(String query, double latitude, double longitude) {
        List<City> cities = repository.getAllCities();
        List<Suggestion> suggestions = new ArrayList<>();

        for (City city : cities) {
            int nbOfDifferentCharacters = LevenshteinDistance.compute(
                    city.getName().toLowerCase(), query.toLowerCase());

            if (nbOfDifferentCharacters <= 2) {

                double distanceKm = HaversineDistance.compute(
                        latitude, longitude, city.getLatitude(), city.getLongitude());

                double score = calculateScore(nbOfDifferentCharacters, distanceKm, query.length());

                suggestions.add(CityToSuggestion.map(city, score));
            }
        }

        return suggestions;
    }

    public List<Suggestion> retrieveSuggestions(String query) {
        List<City> cities = repository.getAllCities();
        List<Suggestion> suggestions = new ArrayList<>();

        for (City city : cities) {
            int nbOfDifferentCharacters = LevenshteinDistance.compute(city.getName().toLowerCase(), query.toLowerCase());

            if (nbOfDifferentCharacters <= 2) {
                suggestions.add(CityToSuggestion.map(city, calculateScore(nbOfDifferentCharacters, 0, query.length())));
            }
        }

        return suggestions;
    }

    private double calculateScore(int nbOfDifferentCharacters, double distanceKm, int queryLength) {
        double score = (double) (queryLength - nbOfDifferentCharacters) / queryLength;

        if (distanceKm > 50) {
            score /= 2;
        }

        return score;
    }
}
