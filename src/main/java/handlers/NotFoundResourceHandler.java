package handlers;

import server.request.RequestParser;
import server.response.ResponseBuilder;
import server.response.Response;
import server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class NotFoundResourceHandler extends Handler {

    @Override
    public String url() {
        return "/not_found_resource";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.GET);
    }

    @Override
    public String buildResponse(RequestParser request) {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 404 Not Found\r\n\r\n").setHeaders("").setBody("").build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
