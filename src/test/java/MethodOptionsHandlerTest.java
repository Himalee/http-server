import Application.MethodOptionsHandler;
import Server.RequestParser;
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
        String request = "OPTIONS /method_options HTTP/1.1";
        RequestParser requestParser =  new RequestParser(request);
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS\r\n\r\n", methodOptionsHandler.handle(requestParser));
    }

    @Test
    public void optionsRequestWithInvalidUrlReturnsNoResponse() {
        String request = "OPTIONS /method_optionss HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", methodOptionsHandler.handle(requestParser));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        String request = "GET /method_options HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", methodOptionsHandler.handle(requestParser));
    }
}
