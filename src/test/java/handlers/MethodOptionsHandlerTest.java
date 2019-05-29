package handlers;

import server.request.Request;
import server.request.RequestParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MethodOptionsHandlerTest {

    MethodOptionsHandler methodOptionsHandler;

    @Before
    public void setUp() {
        methodOptionsHandler = new MethodOptionsHandler();
    }

    @Test
    public void optionsRequestWithMethodOptionsUrlReturns200OkayWithHeadersAndEmptyBody() {
        Request request = new RequestParser("OPTIONS /method_options HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS\r\n\r\n", methodOptionsHandler.handle(request).format());
    }

    @Test
    public void getRequestWithMethodOptionsUrlReturns200OkayWithHeadersAndEmptyBody() {
        Request request = new RequestParser("GET /method_options HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS\r\n\r\n", methodOptionsHandler.handle(request).format());
    }

    @Test
    public void headRequestWithMethodOptionsUrlReturns200OkayWithHeadersAndEmptyBody() {
        Request request = new RequestParser("HEAD /method_options HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS\r\n\r\n", methodOptionsHandler.handle(request).format());
    }

    @Test
    public void postRequestWithMethodOptionsUrlReturns405MethodNotAllowedWithHeaders() {
        Request request = new RequestParser("POST /method_options HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 405 Method Not Allowed\r\nAllow: GET, HEAD, OPTIONS\r\n\r\n", methodOptionsHandler.handle(request).format());
    }
}
