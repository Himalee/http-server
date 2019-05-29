package server.request;

import org.junit.Assert;
import org.junit.Test;

public class RequestParserTest {

    private RequestParser requestParser;

    public void setUpPostRequest() {
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

    public void setUpGetRequest() {
        String request = "GET /simple_get HTTP/1.1\n" +
                "\n";
        requestParser = new RequestParser(request);
    }

    @Test
    public void separateHttpMethodFromRequestLine() {
        setUpPostRequest();
        Assert.assertEquals("POST", requestParser.httpMethod());
    }

    @Test
    public void separateUrlFromRequestLine() {
        setUpPostRequest();
        Assert.assertEquals("/echo_body", requestParser.url());
    }

    @Test
    public void separateBodyFromPostRequest() {
        setUpPostRequest();
        Assert.assertEquals("some body", requestParser.body());
    }

    @Test
    public void getRequestReturnsNoBody() {
        setUpGetRequest();
        Assert.assertEquals("", requestParser.body());
    }
}
