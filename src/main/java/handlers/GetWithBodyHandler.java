package handlers;

import server.request.RequestParser;
import server.response.ResponseBuilder;
import server.response.Response;
import server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class GetWithBodyHandler extends Handler {

    Response response;

    @Override
    public String url() {
        return "/get_with_body";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.HEAD, HTTPMethod.GET);
    }

    @Override
    public String buildResponse(RequestParser request) {
        if (request.getHttpMethod().equals("HEAD")) {
            response = new ResponseBuilder().setStatusCode("HTTP/1.1 200 OK\r\n\r\n").setHeaders("").setBody("").build();
        } else if (request.getHttpMethod().equals("GET")) {
            response = new ResponseBuilder().setStatusCode("HTTP/1.1 405 Method Not Allowed\r\n").setHeaders("Allow: HEAD, OPTIONS\r\n\r\n").setBody("").build();
        }
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}