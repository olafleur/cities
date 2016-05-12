package com.olivierlafleur.cities.util;

import com.olivierlafleur.cities.model.City;
import com.olivierlafleur.cities.model.Suggestion;

public class CityToSuggestion {

    public static Suggestion map(City city, double score) {
        String name = city.getName() + ", " + city.getStateprov() + ", " + city.getCountry();

        return new Suggestion(name, String.valueOf(city.getLatitude()), String.valueOf(city.getLongitude()), score);
    }
}
