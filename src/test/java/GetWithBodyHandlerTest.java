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
        String request = "HEAD /get_with_body HTTP/1.1";
        RequestParser requestParser =  new RequestParser(request);
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", getWithBodyHandler.handle(requestParser));
    }

    @Test
    public void headRequestWithInvalidUrlReturnsNoResponse() {
        String request = "HEAD /get_with_bodys HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", getWithBodyHandler.handle(requestParser));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        String request = "GET /get_with_body HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", getWithBodyHandler.handle(requestParser));
    }
}
