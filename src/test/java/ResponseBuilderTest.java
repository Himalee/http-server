import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResponseBuilderTest {

    private ResponseBuilder responseBuilder;

    @Before
    public void setUp() {
        responseBuilder = new ResponseBuilder();
    }

    @Test
    public void buildResponseWithStatusCode200AndEmptyBody() {
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", responseBuilder.okayWithEmptyBody());
    }

    @Test
    public void buildResponseWithStatusCode200WithHeadersGetHeadOptionsAndEmptyBody() {
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS\r\n\r\n", responseBuilder.okayWithHeadersGetHeadOptions());
    }

    @Test
    public void buildResponseWithStatusCode200WithHeadersGetHeadOptionsPutPostAndEmptyBody() {
        Assert.assertEquals("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", responseBuilder.okayWithHeadersGetHeadOptionsPutPost());
    }

    @Test
    public void buildResponseWithStatusCode404() {
        Assert.assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", responseBuilder.notFound());
    }

    @Test
    public void buildResponseWithStatusCode301AndLocationHeader() {
        String uri = "http://0.0.0.0:5000/simple_get";
        Assert.assertEquals("HTTP/1.1 301 Moved Permanently\r\nLocation: http://0.0.0.0:5000/simple_get\r\n\r\n", responseBuilder.redirectTo(uri));
    }
}
