package com.olivierlafleur.cities.util;

import com.olivierlafleur.cities.model.City;
import com.olivierlafleur.cities.model.Suggestion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CityToSuggestionTest {
    @Test
    public void mapCityToSuggestion() {
        City city = new City(1L, "Amos", 48.13247, -77.21413, "Canada", "QC");

        Suggestion actual = CityToSuggestion.map(city, 0.5);

        Suggestion expected = new Suggestion("Amos, QC, Canada", "48.13247", "-77.21413", 0.5);
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getLatitude(), String.valueOf(actual.getLatitude()));
        assertEquals(expected.getLongitude(), String.valueOf(actual.getLongitude()));
        assertEquals(expected.getScore(), actual.getScore(), 0.00001);
    }
}
