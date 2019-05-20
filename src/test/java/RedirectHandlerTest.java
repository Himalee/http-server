import Application.RedirectHandler;
import Server.RequestParser;
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
        String request = "GET /redirect HTTP/1.1";
        RequestParser requestParser =  new RequestParser(request);
        Assert.assertEquals("HTTP/1.1 301 Moved Permanently\r\nLocation: http://127.0.0.1:5000/simple_get\r\n\r\n", redirectHandler.handle(requestParser));
    }

    @Test
    public void getRequestWithInvalidUrlReturnsNoResponse() {
        String request = "GET /redirects HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", redirectHandler.handle(requestParser));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        String request = "HEAD /redirect HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", redirectHandler.handle(requestParser));
    }
}
