package com.olivierlafleur.cities;

import com.olivierlafleur.cities.repository.TestRepository;
import com.olivierlafleur.cities.resources.SuggestionsResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class TestApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public TestApplication() {
        singletons.add(new SuggestionsResource(new TestRepository()));
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
