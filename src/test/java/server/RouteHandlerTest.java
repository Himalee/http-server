package server;

import org.junit.Assert;
import org.junit.Test;
import server.request.RequestParser;

public class RouteHandlerTest {
    @Test
    public void simpleGetRequestBuildResponse() {
        String request = "GET /simple_get HTTP/1.1\n\n";
        RequestParser requestParser = new RequestParser(request);
        RouteHandler routeHandler = new RouteHandler();
        String response = routeHandler.buildResponse(requestParser);
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", response);
    }
}
