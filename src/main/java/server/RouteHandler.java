package server;

import handlers.Handler;
import handlers.HandlerAssembler;
import server.request.Request;

import java.util.List;

public class RouteHandler {

    public String buildResponse(Request request) {
        StringBuilder response = new StringBuilder();
        List handlers = HandlerAssembler.GET_ALL_HANDLERS;
        for (Object handler : handlers) {
            response.append(((Handler)handler).handle(request));
        }
        return response.toString();
    }
}
