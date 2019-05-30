package handlers;

import server.request.Request;
import server.response.ResponseBuilder;
import server.response.Response;
import server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class MethodOptionsHandler extends Handler {

    @Override
    public String url() {
        return "/method_options";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.GET, HTTPMethod.HEAD, HTTPMethod.OPTIONS);
    }

    @Override
    public Response buildResponse(Request request) {
        return new ResponseBuilder().setStatusLine("HTTP/1.1 200 OK\r\n").setHeaders("Allow: GET, HEAD, OPTIONS\r\n\r\n").setBody("").build();
    }
}
