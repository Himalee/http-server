package handlers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.request.Request;
import server.request.RequestParser;

public class WelcomeHandlerTest {

    WelcomeHandler welcomeHandler;

    @Before
    public void setUp() {
        welcomeHandler = new WelcomeHandler();
    }

    @Test
    public void getRequestWithEmptyUrlReturns200OkayWithBody() {
        Request request = new RequestParser("GET / HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n<!DOCTYPE html> <html> <body> <h1> Himalee's HTTP Server </h1> </body> </html>", welcomeHandler.handle(request).format());
    }

    @Test
    public void headRequestWithEmptyUrlReturns200OkayWithBody() {
        Request request = new RequestParser("HEAD / HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n<!DOCTYPE html> <html> <body> <h1> Himalee's HTTP Server </h1> </body> </html>", welcomeHandler.handle(request).format());
    }

    @Test
    public void postRequestWithEmptyUrlReturns405MethodNotAllowedWithHeaders() {
        Request request = new RequestParser("POST / HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 405 Method Not Allowed\r\nAllow: GET, HEAD\r\n\r\n", welcomeHandler.handle(request).format());
    }
}
