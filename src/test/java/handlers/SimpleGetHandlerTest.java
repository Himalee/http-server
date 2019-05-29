package handlers;

import server.request.Request;
import server.request.RequestParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleGetHandlerTest {

    SimpleGetHandler simpleGetHandler;

    @Before
    public void setUp() {
        simpleGetHandler = new SimpleGetHandler();
    }

    @Test
    public void getRequestWithSimpleGetUrlReturns200OkayWithEmptyBody() {
        Request request = new RequestParser("GET /simple_get HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", simpleGetHandler.handle(request).format());
    }

    @Test
    public void headRequestWithSimpleGetUrlReturns200OkayWithEmptyBody() {
        Request request = new RequestParser("HEAD /simple_get HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", simpleGetHandler.handle(request).format());
    }

    @Test
    public void postRequestWithSimpleGetUrlReturns405MethodNotAllowedWithHeaders() {
        Request request = new RequestParser("POST /simple_get HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 405 Method Not Allowed\r\nAllow: GET, HEAD\r\n\r\n", simpleGetHandler.handle(request).format());
    }
}
