package com.olivierlafleur.cities.resources;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpClient;
import org.junit.Test;

import java.io.IOException;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.OK;
import static junit.framework.Assert.assertEquals;

public class SuggestionsResourceTestInt {
    private static final String HOME_URL = "http://localhost:8080";
    private static final String SUGGESTIONS_ENDPOINT = HOME_URL + "/suggestions";
    private static final String A_CITY_QUERY = "?q=Amos";
    private static final String A_WRONG_LAT_LONG = "&lat=48abcdef&long=-77.21413";

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
    public void wrongLatitudeLongitude_returnsBadRequest() throws IOException {
        int status = getRequest(SUGGESTIONS_ENDPOINT + A_CITY_QUERY + A_WRONG_LAT_LONG);

        assertEquals(BAD_REQUEST.getStatusCode(), status);
    }

    private int getRequest(String request) throws IOException {
        return httpClient.executeMethod(new GetMethod(request));
    }
}
