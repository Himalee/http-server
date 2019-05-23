package handlers;

import server.request.RequestParser;
import server.response.ResponseBuilder;
import server.response.Response;
import server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class MethodOptionsTwoHandler extends Handler {

    @Override
    public String url() {
        return "/method_options2";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.OPTIONS);
    }

    @Override
    public String buildResponse(RequestParser request) {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 200 OK\r\n").setHeaders("Allow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n").setBody("").build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
