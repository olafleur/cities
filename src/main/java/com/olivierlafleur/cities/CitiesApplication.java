package com.olivierlafleur.cities;

import com.olivierlafleur.cities.repository.MySqlRepository;
import com.olivierlafleur.cities.resources.SuggestionsResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class CitiesApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public CitiesApplication() {
        singletons.add(new SuggestionsResource(new MySqlRepository()));
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
