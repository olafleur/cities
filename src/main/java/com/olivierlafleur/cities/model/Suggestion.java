package com.olivierlafleur.cities.model;

public class Suggestion {
    private String name;
    private String latitude;
    private String longitude;
    private double score;

    public Suggestion(String name, String latitude, String longitude, double score) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public double getScore() {
        return score;
    }
}
