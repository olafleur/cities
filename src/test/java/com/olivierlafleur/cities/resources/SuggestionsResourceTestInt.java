package com.olivierlafleur.cities.resources;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpClient;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class SuggestionsResourceTestInt {
    private static final String HOME_URL = "http://localhost:8080";
    private static final String SUGGESTIONS_ENDPOINT = HOME_URL + "/suggestions";

    @Test
    public void noParameter_badRequest() throws IOException {
        HttpClient httpClient = new HttpClient();
        {
            GetMethod getMethod = new GetMethod(SUGGESTIONS_ENDPOINT);
            int status = httpClient.executeMethod(getMethod);

            assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), status);
        }
    }
}
