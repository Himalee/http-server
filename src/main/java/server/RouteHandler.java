package server;

import handlers.Handler;
import handlers.HandlerAssembler;
import server.request.RequestParser;

import java.util.List;

public class RouteHandler {

    public String buildResponse(RequestParser requestParser) {
        StringBuilder response = new StringBuilder();
        List handlers = HandlerAssembler.GET_ALL_HANDLERS;
        for (Object handler : handlers) {
            response.append(((Handler)handler).handle(requestParser));
        }
        return response.toString();
    }
}
