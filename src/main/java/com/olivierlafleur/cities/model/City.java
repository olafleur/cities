package com.olivierlafleur.cities.model;

public class City {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private String country;
    private String stateprov;

    public City(Long id, String name, double latitude, double longitude, String country, String stateprov) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.stateprov = stateprov;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getStateprov() {
        return stateprov;
    }
}
