package com.olivierlafleur.cities.repository;

import com.olivierlafleur.cities.model.City;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements Repository {
    @Override
    public List<City> getAllCities() {
        return new ArrayList<>();
    }
}
