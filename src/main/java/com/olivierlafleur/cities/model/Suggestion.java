package com.olivierlafleur.cities.model;

public class Suggestion {
    private String name;
    private double latitude;
    private double longitude;
    private double score;

    public Suggestion(String name, double latitude, double longitude, double score) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.score = score;
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

    public double getScore() {
        return score;
    }
}
