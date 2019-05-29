package handlers;

import server.request.Request;
import server.request.RequestParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetWithBodyHandlerTest {

    GetWithBodyHandler getWithBodyHandler;

    @Before
    public void setUp() {
        getWithBodyHandler = new GetWithBodyHandler();
    }

    @Test
    public void headRequestWithGetWithBodyUrlReturns200OkayWithEmptyBody() {
        Request request = new RequestParser("HEAD /get_with_body HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", getWithBodyHandler.handle(request).format());
    }

    @Test
    public void optionsRequestWithGetWithBodyUrlReturns200OkayWithEmptyBody() {
        Request request = new RequestParser("OPTIONS /get_with_body HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", getWithBodyHandler.handle(request).format());
    }

    @Test
    public void getRequestWithGetWithBodyUrlReturns405MethodNotAllowedWithHeaders() {
        Request request = new RequestParser("GET /get_with_body HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 405 Method Not Allowed\r\nAllow: HEAD, OPTIONS\r\n\r\n", getWithBodyHandler.handle(request).format());
    }
}
