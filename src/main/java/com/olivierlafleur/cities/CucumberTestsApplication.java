package com.olivierlafleur.cities;

import com.olivierlafleur.cities.model.City;
import com.olivierlafleur.cities.repository.Repository;
import com.olivierlafleur.cities.resources.SuggestionsResource;

import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CucumberTestsApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public CucumberTestsApplication() {
        singletons.add(new SuggestionsResource(new CucumberTestsRepository()));
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    private class CucumberTestsRepository implements Repository {
        @Override
        public List<City> getAllCities() {
            List<City> cities = new ArrayList<>();

            cities.add(new City(8L, "St-Romuald", 3, 4, "Canada", "Québec"));
            cities.add(new City(9L, "Amos", 45.3, 37.2, "Canada", "Québec"));

            return cities;
        }
    }
}
