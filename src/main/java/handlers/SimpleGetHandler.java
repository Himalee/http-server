package handlers;

import server.request.Request;
import server.response.ResponseBuilder;
import server.response.Response;
import server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class SimpleGetHandler extends Handler {

    @Override
    public String url() {
        return "/simple_get";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.GET, HTTPMethod.HEAD);
    }

    @Override
    public String buildResponse(Request request) {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 200 OK\r\n\r\n").setHeaders("").setBody("").build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
