package handlers;

import server.request.Request;
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
        return Arrays.asList(HTTPMethod.GET, HTTPMethod.HEAD, HTTPMethod.OPTIONS, HTTPMethod.PUT, HTTPMethod.POST);
    }

    @Override
    public Response buildResponse(Request request) {
        return new ResponseBuilder().setStatusLine("HTTP/1.1 200 OK\r\n").setHeaders("Allow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n").setBody("").build();
    }
}
