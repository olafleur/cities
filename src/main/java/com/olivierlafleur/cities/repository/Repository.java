package com.olivierlafleur.cities.repository;

import com.olivierlafleur.cities.model.City;

import java.util.List;

public interface Repository {
    List<City> getAllCities();
}
