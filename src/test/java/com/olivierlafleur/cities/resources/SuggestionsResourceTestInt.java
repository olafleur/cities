package com.olivierlafleur.cities.resources;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpClient;
import org.junit.Test;

import java.io.IOException;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.Assert.assertEquals;

public class SuggestionsResourceTestInt {
    private static final String HOME_URL = "http://localhost";
    private static final String SUGGESTIONS_ENDPOINT = HOME_URL + "/suggestions";
    private static final String A_CITY_QUERY = "?q=Amos";
    private static final String A_NONEXISTENT_CITY_QUERY = "?q=NoCityHasThisName";
    private static final String A_NON_NUMERICAL_LAT_LONG = "&lat=48abcdef&long=-77.21413";
    private static final String A_NON_VALID_LAT_LONG = "&lat=48&long=181";

    private final HttpClient httpClient = new HttpClient();

    @Test
    public void noParameter_badRequest() throws IOException {
        int status = getRequest(SUGGESTIONS_ENDPOINT);

        assertEquals(BAD_REQUEST.getStatusCode(), status);
    }

    @Test
    public void queryPresent_returnsOk() throws IOException {
        int status = getRequest(SUGGESTIONS_ENDPOINT + A_CITY_QUERY);

        assertEquals(OK.getStatusCode(), status);
    }

    @Test
    public void nonNumericalLatitude_returnsBadRequest() throws IOException {
        int status = getRequest(SUGGESTIONS_ENDPOINT + A_CITY_QUERY + A_NON_NUMERICAL_LAT_LONG);

        assertEquals(BAD_REQUEST.getStatusCode(), status);
    }

    @Test
    public void invalidCoordinates_returnsBadRequest() throws IOException {
        int status = getRequest(SUGGESTIONS_ENDPOINT + A_CITY_QUERY + A_NON_VALID_LAT_LONG);

        assertEquals(BAD_REQUEST.getStatusCode(), status);
    }

    @Test
    public void nonexistentCity_returnNotFound() throws IOException {
        int status = getRequest(SUGGESTIONS_ENDPOINT + A_NONEXISTENT_CITY_QUERY);

        assertEquals(NOT_FOUND.getStatusCode(), status);
    }

    private int getRequest(String request) throws IOException {
        return httpClient.executeMethod(new GetMethod(request));
    }
}
