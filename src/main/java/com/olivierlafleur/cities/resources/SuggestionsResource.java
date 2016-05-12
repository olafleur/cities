package com.olivierlafleur.cities.resources;

import com.olivierlafleur.cities.model.Suggestion;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Path("/suggestions")
@Produces(MediaType.APPLICATION_JSON)
public class SuggestionsResource {
    private final SuggestionService suggestionService = new SuggestionService();

    @GET
    public Response getSuggestions(@QueryParam("q") String query,
                                   @QueryParam("lat") double latitude,
                                   @QueryParam("long") double longitude) {
        if(query == null || query.isEmpty()) {
            return Response.status(BAD_REQUEST).build();
        }

        List<Suggestion> suggestions = suggestionService.retrieveSuggestions(query, latitude, longitude);

        return Response.ok(suggestions).build();
    }
}
