package server;

import org.junit.Assert;
import org.junit.Test;
import server.request.Request;
import server.request.RequestParser;
import server.response.Response;

public class RouteHandlerTest {
    @Test
    public void simpleGetRequestBuildResponse() {
        Request request = new RequestParser("GET /simple_get HTTP/1.1\n\n").buildRequest();
        RouteHandler routeHandler = new RouteHandler();
        Response response = routeHandler.getResponse(request);
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", response.format());
    }
}
