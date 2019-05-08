import org.junit.Assert;
import org.junit.Test;

public class ResponseBuilderTest {
    @Test
    public void buildResponseWithStatusCode200AndEmptyBody() {
        ResponseBuilder responseBuilder = new ResponseBuilder();
        Assert.assertEquals("HTTP/1.1 200 OK\r\n\r\n", responseBuilder.okayWithEmptyBody());
    }
}
