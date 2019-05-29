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
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", methodOptionsTwoHandler.handle(request));
    }

    @Test
    public void optionsRequestWithInvalidUrlReturnsNoResponse() {
        Request request = new RequestParser("OPTIONS /method_option3 HTTP/1.1").buildRequest();
        Assert.assertEquals("", methodOptionsTwoHandler.handle(request));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        Request request = new RequestParser("GET /get_with_body HTTP/1.1").buildRequest();
        Assert.assertEquals("", methodOptionsTwoHandler.handle(request));
    }
}
