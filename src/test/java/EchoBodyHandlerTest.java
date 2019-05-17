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
        String request = "POST /echo_body HTTP/1.1\nsome body";
        RequestParser requestParser =  new RequestParser(request);
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\nsome body", echoBodyHandler.handle(requestParser));
    }

    @Test
    public void postRequestWithInvalidEchoBodyUrlReturnsNoResponse() {
        String request = "POST /echo_bodys HTTP/1.1\nsome body";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", echoBodyHandler.handle(requestParser));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        String request = "GET /echo_body HTTP/1.1\nsome body";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", echoBodyHandler.handle(requestParser));
    }
}
