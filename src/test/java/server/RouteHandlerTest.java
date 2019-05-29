package server;

import org.junit.Assert;
import org.junit.Test;
import server.request.Request;
import server.request.RequestParser;

public class RouteHandlerTest {
    @Test
    public void simpleGetRequestBuildResponse() {
        Request request = new RequestParser("GET /simple_get HTTP/1.1\n\n").buildRequest();
        RouteHandler routeHandler = new RouteHandler();
        String response = routeHandler.buildResponse(request);
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", response);
    }
}
