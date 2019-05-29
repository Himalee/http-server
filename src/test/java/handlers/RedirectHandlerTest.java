package handlers;

import server.request.Request;
import server.request.RequestParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RedirectHandlerTest {

    RedirectHandler redirectHandler;

    @Before
    public void setUp() {
        redirectHandler = new RedirectHandler();
    }

    @Test
    public void getRequestWithNotFoundResourceUrlReturns404NotFound() {
        Request request = new RequestParser("GET /redirect HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 301 Moved Permanently\r\nLocation: http://127.0.0.1:5000/simple_get\r\n\r\n", redirectHandler.handle(request));
    }

    @Test
    public void getRequestWithInvalidUrlReturnsNoResponse() {
        Request request = new RequestParser("GET /redirects HTTP/1.1").buildRequest();
        Assert.assertEquals("", redirectHandler.handle(request));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        Request request = new RequestParser("HEAD /redirect HTTP/1.1").buildRequest();
        Assert.assertEquals("", redirectHandler.handle(request));
    }
}
