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

    private final HttpClient httpClient = new HttpClient();

    @Test
    public void noParameter_badRequest() throws IOException {
        int status = getRequest(SUGGESTIONS_ENDPOINT);

        assertEquals(BAD_REQUEST.getStatusCode(), status);
    }

    @Test
    public void parameterPresent_returnsOk() throws IOException {
        int status = getRequest(SUGGESTIONS_ENDPOINT + "?q=Amos");

        assertEquals(OK.getStatusCode(), status);
    }

    private int getRequest(String request) throws IOException {
        return httpClient.executeMethod(new GetMethod(request));
    }
}
