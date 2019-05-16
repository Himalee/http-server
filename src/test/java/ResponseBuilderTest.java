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
}
