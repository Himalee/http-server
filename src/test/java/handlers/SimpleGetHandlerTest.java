package handlers;

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
        String request = "GET /simple_get HTTP/1.1";
        RequestParser requestParser =  new RequestParser(request);
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", simpleGetHandler.handle(requestParser));
    }

    @Test
    public void headRequestWithSimpleGetUrlReturns200OkayWithEmptyBody() {
        String request = "HEAD /simple_get HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", simpleGetHandler.handle(requestParser));
    }

    @Test
    public void getRequestWithInvalidUrlReturnsNoResponse() {
        String request = "GET /simple_gets HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", simpleGetHandler.handle(requestParser));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        String request = "POST /simple_gets HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", simpleGetHandler.handle(requestParser));
    }
}
