package handlers;

import server.request.Request;
import server.response.Response;
import server.response.ResponseBuilder;

import java.util.List;

public abstract class Handler {

    public final Response handle(Request request) {
        boolean requestContainsValidHttpMethod = httpMethods().contains(request.getHttpMethod());
        if (requestContainsValidHttpMethod) {
            return buildResponse(request);
        } else {
            return new ResponseBuilder().setStatusCode("HTTP/1.1 405 Method Not Allowed\r\n").setHeaders("Allow: " + String.join(", ", this.httpMethods()) + "\r\n\r\n").setBody("").build();
        }
    }

    public abstract String url();
    public abstract List<String> httpMethods();
    public abstract Response buildResponse(Request request);
}