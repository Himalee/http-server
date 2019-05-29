package server;

import org.junit.Assert;
import org.junit.Test;
import server.request.Request;
import server.request.RequestParser;
import server.response.Response;

public class RouteHandlerTest {

    RouteHandler routeHandler;

    public Response routeRequestAndGetResponseFor(Request request) {
        routeHandler = new RouteHandler();
        return routeHandler.getResponse(request);
    }

    @Test
    public void simpleGetRequestBuild200Response() {
        Request request = new RequestParser("GET /simple_get HTTP/1.1\n\n").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", routeRequestAndGetResponseFor(request).format());
    }

    @Test
    public void randomUrlBuild404Response() {
        Request request = new RequestParser("GET /random_url HTTP/1.1\n\n").buildRequest();
        Assert.assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", routeRequestAndGetResponseFor(request).format());
    }
}
