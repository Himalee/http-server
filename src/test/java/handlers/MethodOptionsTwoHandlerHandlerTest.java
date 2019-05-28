package handlers;

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
        String request = "OPTIONS /method_options2 HTTP/1.1";
        RequestParser requestParser =  new RequestParser(request);
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", methodOptionsTwoHandler.handle(requestParser));
    }

    @Test
    public void optionsRequestWithInvalidUrlReturnsNoResponse() {
        String request = "OPTIONS /method_option3 HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", methodOptionsTwoHandler.handle(requestParser));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        String request = "GET /get_with_body HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", methodOptionsTwoHandler.handle(requestParser));
    }
}
