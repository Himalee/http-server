package Application;

import Server.RequestParser;

import java.util.List;

public abstract class Handler {

    public final String handle(RequestParser request) {
        StringBuilder response = new StringBuilder();
        boolean requestContainsValidHttpMethod = httpMethods().contains(request.getHttpMethod());
        boolean requestContainsValidUrl = request.getUrl().equals(url());
        if (requestContainsValidUrl && requestContainsValidHttpMethod) {
            response.append(buildResponse(request));
        }
        return response.toString();
    }

    public abstract String url();
    public abstract List<String> httpMethods();
    public abstract String buildResponse(RequestParser request);
}