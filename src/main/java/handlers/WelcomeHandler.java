package handlers;

import server.HTTPMethod;
import server.request.Request;
import server.response.Response;
import server.response.ResponseBuilder;

import java.util.Arrays;
import java.util.List;

public class WelcomeHandler extends Handler {

    @Override
    public String url() {
        return "/";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.GET, HTTPMethod.HEAD);
    }

    @Override
    public Response buildResponse(Request request) {
        return new ResponseBuilder()
                .setStatusLine("HTTP/1.1 200 OK\r\n\r\n")
                .setHeaders("")
                .setBody("<!DOCTYPE html> <html> " +
                        "<head> <title>Himalee's HTTP Server</title> </head> " +
                        "<body> <h1> Himalee's HTTP Server </h1> </body> </html>").build();
    }
}
