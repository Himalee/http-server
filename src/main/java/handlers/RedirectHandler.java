package handlers;

import server.request.Request;
import server.response.ResponseBuilder;
import server.response.Response;
import server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class RedirectHandler extends Handler {

    private static final String REDIRECT_URL = System.getenv("REDIRECT_URL_HOST") + System.getenv("PORT") + "/simple_get";

    @Override
    public String url() {
        return "/redirect";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList(HTTPMethod.GET);
    }

    @Override
    public Response buildResponse(Request request) {
        return new ResponseBuilder().setStatusLine("HTTP/1.1 301 Moved Permanently\r\n").setHeaders("Location: " + REDIRECT_URL + "\r\n\r\n").setBody("").build();
    }
}
