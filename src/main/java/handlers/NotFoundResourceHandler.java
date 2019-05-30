package handlers;

import server.request.Request;
import server.response.ResponseBuilder;
import server.response.Response;
import server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class NotFoundResourceHandler extends Handler {

    @Override
    public String url() {
        return null;
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.GET, HTTPMethod.HEAD, HTTPMethod.OPTIONS, HTTPMethod.POST);
    }

    @Override
    public Response buildResponse(Request request) {
        return new ResponseBuilder().setStatusLine("HTTP/1.1 404 Not Found\r\n\r\n").setHeaders("").setBody("").build();
    }
}
