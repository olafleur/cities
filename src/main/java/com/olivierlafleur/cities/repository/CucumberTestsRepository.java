package com.olivierlafleur.cities.repository;

import com.olivierlafleur.cities.model.City;

import java.util.ArrayList;
import java.util.List;

public class CucumberTestsRepository implements Repository {
    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();

        cities.add(new City(8L, "Leviko", 3, 4, "Canada", "Québec"));

        return cities;
    }
}
