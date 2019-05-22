package handlers;

import server.request.RequestParser;
import server.response.ResponseBuilder;
import server.response.Response;

import java.util.Arrays;
import java.util.List;

public class EchoBodyHandler extends Handler {

    @Override
    public String url() {
        return "/echo_body";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList("POST");
    }

    @Override
    public String buildResponse(RequestParser request) {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 200 OK\r\n\r\n").setHeaders("").setBody(request.getBody()).build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
