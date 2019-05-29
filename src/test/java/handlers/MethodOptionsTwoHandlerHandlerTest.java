package handlers;

import server.request.Request;
import server.request.RequestParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MethodOptionsTwoHandlerHandlerTest {

    MethodOptionsTwoHandler methodOptionsTwoHandler;

    @Before
    public void setUp() {
        methodOptionsTwoHandler = new MethodOptionsTwoHandler();
    }

    @Test
    public void optionsRequestWithMethodOptionsTwoUrlReturns200OkayWithHeadersAndEmptyBody() {
        Request request = new RequestParser("OPTIONS /method_options2 HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", methodOptionsTwoHandler.handle(request).format());
    }

    @Test
    public void headRequestWithMethodOptionsTwoUrlReturns200OkayWithHeadersAndEmptyBody() {
        Request request = new RequestParser("HEAD /method_options2 HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", methodOptionsTwoHandler.handle(request).format());
    }

    @Test
    public void getRequestWithMethodOptionsTwoUrlReturns200OkayWithHeadersAndEmptyBody() {
        Request request = new RequestParser("GET /method_options2 HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", methodOptionsTwoHandler.handle(request).format());
    }

    @Test
    public void putRequestWithMethodOptionsTwoUrlReturns200OkayWithHeadersAndEmptyBody() {
        Request request = new RequestParser("PUT /method_options2 HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", methodOptionsTwoHandler.handle(request).format());
    }

    @Test
    public void postRequestWithMethodOptionsTwoUrlReturns200OkayWithHeadersAndEmptyBody() {
        Request request = new RequestParser("POST /method_options2 HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", methodOptionsTwoHandler.handle(request).format());
    }

    @Test
    public void deleteRequestWithMethodOptionsTwoUrlReturns405MethodNotAllowedWithHeaders() {
        Request request = new RequestParser("DELETE /method_options2 HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 405 Method Not Allowed\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", methodOptionsTwoHandler.handle(request).format());
    }
}
