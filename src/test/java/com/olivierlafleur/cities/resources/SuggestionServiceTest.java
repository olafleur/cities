package com.olivierlafleur.cities.resources;

import com.olivierlafleur.cities.model.City;
import com.olivierlafleur.cities.model.Suggestion;
import com.olivierlafleur.cities.repository.Repository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SuggestionServiceTest {
    @Test
    public void queryReturnTwoSuggestions() {
        SuggestionService suggestionService = new SuggestionService(new TestRepository());

        List<Suggestion> suggestions = suggestionService.retrieveSuggestions("amos");

        assertEquals(2, suggestions.size());
    }

    private class TestRepository implements Repository {
        @Override
        public List<City> getAllCities() {
            List<City> cities = new ArrayList<>();

            cities.add(new City(1l, "Amos", 0, 0, "Canada", "QC"));
            cities.add(new City(2l, "Québec", 0, 0, "Canada", "QC"));
            cities.add(new City(3l, "Omas", 0, 0, "Other country", "AB"));

            return cities;
        }
    }
}
