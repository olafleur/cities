package com.olivierlafleur.cities.repository;

import com.olivierlafleur.cities.model.City;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements Repository {
    private List<City> cities;

    public InMemoryRepository() {
        cities = retrieveCities();
    }

    @Override
    public List<City> getAllCities() {
        return cities;
    }

    private List<City> retrieveCities() {
        List<City> cities = new ArrayList<>();

        cities.add(new City(1l, "Amos", 48.56688, -78.1162, "Canada", "QC"));

        return cities;
    }
}
