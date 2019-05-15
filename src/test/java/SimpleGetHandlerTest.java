import org.junit.Assert;
import org.junit.Test;

public class SimpleGetHandlerTest {

    @Test
    public void getRequestWithSimpleGetUrlReturns200OkayResponseWithEmptyBody() {
        SimpleGetHandler simpleGetHandler = new SimpleGetHandler();
        String request = "GET /simple_get HTTP/1.1";
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", simpleGetHandler.handle(request));
    }

    @Test
    public void headRequestWithSimpleHeadUrlReturns200OkayResponseWithEmptyBody() {
        SimpleGetHandler simpleGetHandler = new SimpleGetHandler();
        String request = "HEAD /simple_get HTTP/1.1";
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", simpleGetHandler.handle(request));
    }
}
