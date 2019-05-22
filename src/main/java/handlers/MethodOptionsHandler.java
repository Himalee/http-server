package handlers;

import server.request.RequestParser;
import server.response.ResponseBuilder;
import server.response.Response;

import java.util.Arrays;
import java.util.List;

public class MethodOptionsHandler extends Handler {

    @Override
    public String url() {
        return "/method_options";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList("OPTIONS");
    }

    @Override
    public String buildResponse(RequestParser request) {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 200 OK\r\n").setHeaders("Allow: GET, HEAD, OPTIONS\r\n\r\n").setBody("").build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
