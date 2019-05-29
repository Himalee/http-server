package handlers;

import server.request.Request;
import server.request.RequestParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EchoBodyHandlerTest {

    EchoBodyHandler echoBodyHandler;

    @Before
    public void setUp() {
        echoBodyHandler = new EchoBodyHandler();
    }

    @Test
    public void postRequestWithEchoBodyUrlReturns200OkayWithBody() {
        Request request = new RequestParser("POST /echo_body HTTP/1.1\nsome body").buildRequest();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\nsome body", echoBodyHandler.handle(request));
    }

    @Test
    public void postRequestWithInvalidEchoBodyUrlReturnsNoResponse() {
        Request request = new RequestParser("POST /echo_bodys HTTP/1.1\nsome body").buildRequest();
        Assert.assertEquals("", echoBodyHandler.handle(request));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        Request request = new RequestParser("GET /echo_body HTTP/1.1\nsome body").buildRequest();
        Assert.assertEquals("", echoBodyHandler.handle(request));
    }
}
