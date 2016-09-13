package com.olivierlafleur.cities.repository;

import com.olivierlafleur.cities.model.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvRepository implements Repository {
    private List<City> cities;

    public CsvRepository() {
        cities = retrieveCities();
    }

    @Override
    public List getAllCities() {
        return cities;
    }

    private List<City> retrieveCities() {
        return parseCsvFile("Cities.csv");
    }

    private List<City> parseCsvFile(String file) {
        BufferedReader br;
        String line;
        List<City> cities = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(file);

        try {
            br = new BufferedReader(new InputStreamReader(resourceAsStream));

            while ((line = br.readLine()) != null) {
                String[] city = line.split(", ");

                cities.add(new City(Long.valueOf(city[0]), city[1], Double.valueOf(city[2]),
                        Double.valueOf(city[3]), city[4], city[5]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }
}
