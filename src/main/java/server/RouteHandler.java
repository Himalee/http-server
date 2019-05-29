package server;

import handlers.Handler;
import handlers.HandlerAssembler;
import handlers.NotFoundResourceHandler;
import server.request.Request;
import server.response.Response;

import java.util.List;

public class RouteHandler {

    public Response getResponse(Request request) {
        List<Handler> handlers = HandlerAssembler.GET_ALL_HANDLERS;
        for (Handler handler : handlers) {
            if (request.getUrl().equals(handler.url())) {
               return handler.handle(request);
            }
        }
        return new NotFoundResourceHandler().buildResponse(request);
    }
}
