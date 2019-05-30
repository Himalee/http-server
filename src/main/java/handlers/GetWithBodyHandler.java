package handlers;

import server.request.Request;
import server.response.ResponseBuilder;
import server.response.Response;
import server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class GetWithBodyHandler extends Handler {

    @Override
    public String url() {
        return "/get_with_body";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.HEAD, HTTPMethod.OPTIONS);
    }

    @Override
    public Response buildResponse(Request request) {
        return new ResponseBuilder().setStatusLine("HTTP/1.1 200 OK\r\n\r\n").setHeaders("").setBody("").build();
    }
}
