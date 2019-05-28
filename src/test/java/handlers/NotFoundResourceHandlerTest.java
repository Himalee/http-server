package handlers;

import server.request.RequestParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NotFoundResourceHandlerTest {

    NotFoundResourceHandler notFoundResourceHandler;

    @Before
    public void setUp() {
        notFoundResourceHandler = new NotFoundResourceHandler();
    }

    @Test
    public void getRequestWithNotFoundResourceUrlReturns404NotFound() {
        String request = "GET /not_found_resource HTTP/1.1";
        RequestParser requestParser =  new RequestParser(request);
        Assert.assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", notFoundResourceHandler.handle(requestParser));
    }

    @Test
    public void getRequestWithInvalidUrlReturnsNoResponse() {
        String request = "GET /not_found_resources HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", notFoundResourceHandler.handle(requestParser));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        String request = "HEAD /not_found_resource HTTP/1.1";
        RequestParser requestParser = new RequestParser(request);
        Assert.assertEquals("", notFoundResourceHandler.handle(requestParser));
    }
}
