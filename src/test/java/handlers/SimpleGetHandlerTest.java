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
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", simpleGetHandler.handle(request));
    }

    @Test
    public void headRequestWithSimpleGetUrlReturns200OkayWithEmptyBody() {
        Request request = new RequestParser("HEAD /simple_get HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", simpleGetHandler.handle(request));
    }

    @Test
    public void getRequestWithInvalidUrlReturnsNoResponse() {
        Request request = new RequestParser("GET /simple_gets HTTP/1.1").buildRequest();
        Assert.assertEquals("", simpleGetHandler.handle(request));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        Request request = new RequestParser("POST /simple_gets HTTP/1.1").buildRequest();
        Assert.assertEquals("", simpleGetHandler.handle(request));
    }
}
