package com.olivierlafleur.cities.cucumber;

import com.olivierlafleur.cities.model.City;
import com.olivierlafleur.cities.model.Suggestion;
import com.olivierlafleur.cities.repository.Repository;
import com.olivierlafleur.cities.resources.SuggestionService;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Étantdonné;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RechercheUnitSteps {
    private SuggestionService suggestionService;
    private List<Suggestion> suggestions;

    @Étantdonné("^que j'ai les villes suivantes$")
    public void queJAiLesVillesSuivantes(List<String> villes) throws Throwable {
        TestRepository testRepository = new TestRepository(villes);
        suggestionService = new SuggestionService(testRepository);
    }

    @Et("^que je choisis la chaîne (.*)$")
    public void queJeChoisisLaChaîne(String chaine) throws Throwable {
        suggestions = suggestionService.retrieveSuggestions(chaine);
    }

    @Alors("^je devrais avoir (\\d+) villes suggérées$")
    public void jeDevraisAvoirVillesSuggérées(int nb) throws Throwable {
        assertEquals(nb, suggestions.size());
    }

    private class TestRepository implements Repository {
        private List<City> cities = new ArrayList<>();
        private long id = 1L;

        TestRepository(List<String> cities) {
            for(String ville : cities)
            {
                this.cities.add(new City(id, ville , 0, 0, "Canada", "QC"));
                id++;
            }
        }

        @Override
        public List<City> getAllCities() {
            return cities;
        }
    }
}
