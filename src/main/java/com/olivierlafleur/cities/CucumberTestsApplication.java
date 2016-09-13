package com.olivierlafleur.cities;

import com.olivierlafleur.cities.repository.CucumberTestsRepository;
import com.olivierlafleur.cities.resources.SuggestionsResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class CucumberTestsApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public CucumberTestsApplication() {
        singletons.add(new SuggestionsResource(new CucumberTestsRepository()));
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
