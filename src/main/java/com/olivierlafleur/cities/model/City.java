package com.olivierlafleur.cities.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class City {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private String country;
    private String stateprov;

    //ORM
    public City() {}

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStateprov(String stateprov) {
        this.stateprov = stateprov;
    }
}
