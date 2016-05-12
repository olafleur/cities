package com.olivierlafleur.cities.resources;

import com.olivierlafleur.cities.model.Suggestion;
import com.olivierlafleur.cities.repository.InMemoryRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Collections;
import java.util.List;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Path("/suggestions")
@Produces(MediaType.APPLICATION_JSON)
public class SuggestionsResource {
    private final SuggestionService suggestionService = new SuggestionService(new InMemoryRepository());

    @GET
    public Response getSuggestions(@QueryParam("q") String query,
                                   @QueryParam("lat") String latitude,
                                   @QueryParam("long") String longitude) {
        if (query == null || query.isEmpty()) {
            return Response.status(BAD_REQUEST).build();
        }

        List<Suggestion> suggestions;

        if (latitude == null || longitude == null) {
            suggestions = suggestionService.retrieveSuggestions(query);
        } else {

            double lat;
            double lng;

            try {
                lat = Double.parseDouble(latitude);
                lng = Double.parseDouble(longitude);
            } catch (NumberFormatException e) {
                return Response.status(BAD_REQUEST).build();
            }

            if (wrongCoordinates(lat, lng)) {
                return Response.status(BAD_REQUEST).build();
            }

            suggestions = suggestionService.retrieveSuggestions(query, lat, lng);
        }

        Collections.sort(suggestions, (suggestion1, suggestion2) -> (int)(suggestion2.getScore()*10 - suggestion1.getScore()*10));

        return Response.ok(suggestions).build();
    }

    private boolean wrongCoordinates(double lat, double lng) {
        return lat < 0 || lat > 90 || lng < -180 || lng > 180;
    }
}
