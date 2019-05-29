package handlers;

import server.request.Request;
import server.response.ResponseBuilder;
import server.response.Response;
import server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class RedirectHandler extends Handler {

    private static final String REDIRECT_URL = "http://127.0.0.1:5000/simple_get";

    @Override
    public String url() {
        return "/redirect";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.GET);
    }

    @Override
    public String buildResponse(Request request) {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 301 Moved Permanently\r\n").setHeaders("Location: " + REDIRECT_URL + "\r\n\r\n").setBody("").build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
