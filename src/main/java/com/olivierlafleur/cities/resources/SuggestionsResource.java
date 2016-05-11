package com.olivierlafleur.cities.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/suggestions")
@Produces(MediaType.APPLICATION_JSON)
public class SuggestionsResource {
    @GET
    public Response getSuggestions(@QueryParam("q") String query) {
        return Response.ok("Allo").build();
    }
}
