import Server.RequestParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RequestParserTest {

    private RequestParser requestParser;

   @Before
   public void setUp() {
       String request = "POST /echo_body HTTP/1.1\n" +
               "Accept-Encoding: gzip;q=1.0,deflate;q=0.6,identity;q=0.3\n" +
               "Accept: */*\n" +
               "User-Agent: Ruby\n" +
               "Connection: close\n" +
               "Host: 127.0.0.1:5000\n" +
               "Content-Length: 9\n" +
               "Content-Type: application/x-www-form-urlencoded\n" +
               "\n" +
               "some body";
       requestParser = new RequestParser(request);
   }

    @Test
    public void separateHttpMethodFromRequestLine() {
        Assert.assertEquals("POST", requestParser.getHttpMethod());
    }

    @Test
    public void separateUrlFromRequestLine() {
        Assert.assertEquals("/echo_body", requestParser.getUrl());
    }

    @Test
    public void separateBodyFromRequest() {
       Assert.assertEquals("some body", requestParser.getBody());
    }
}
