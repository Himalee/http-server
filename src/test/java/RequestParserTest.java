import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RequestParserTest {

    private RequestParser requestParser;

   @Before
   public void setUp() {
       String request = "GET /get_with_body HTTP/1.1\n" +
               "Accept-Encoding: gzip;q=1.0,deflate;q=0.6,identity;q=0.3\n" +
               "Accept: */*\n" +
               "User-Agent: Ruby\n" +
               "Connection: close\n" +
               "Host: 127.0.0.1:5000";
       requestParser = new RequestParser(request);
   }

    @Test
    public void separateHttpMethodFromRequestLine() {
        Assert.assertEquals("GET", requestParser.getHttpMethod());
    }

    @Test
    public void separateUrlFromRequestLine() {
        Assert.assertEquals("/get_with_body", requestParser.getUrl());
    }
}
