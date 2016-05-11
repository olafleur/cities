package com.olivierlafleur.cities.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/suggestions")
@Produces(MediaType.APPLICATION_JSON)
public class SuggestionsResource {
    @GET
    public Response getSuggestions(@QueryParam("q") String query) {
        if(query == null || query.isEmpty()) {
            return Response.status(BAD_REQUEST).build();
        }

        return Response.status(OK).build();
    }
}
