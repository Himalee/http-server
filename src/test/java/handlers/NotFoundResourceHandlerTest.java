package handlers;

import server.request.Request;
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
        Request request = new RequestParser("GET /not_found_resource HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", notFoundResourceHandler.handle(request).format());
    }

    @Test
    public void headRequestWithNotFoundResourceUrlReturns404NotFound() {
        Request request = new RequestParser("HEAD /not_found_resource HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", notFoundResourceHandler.handle(request).format());
    }

    @Test
    public void optionsRequestWithNotFoundResourceUrlReturns404NotFound() {
        Request request = new RequestParser("OPTIONS /not_found_resource HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", notFoundResourceHandler.handle(request).format());
    }

    @Test
    public void postRequestWithNotFoundResourceUrlReturns404NotFound() {
        Request request = new RequestParser("POST /not_found_resource HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", notFoundResourceHandler.handle(request).format());
    }

    @Test
    public void getRequestWithRandomUrlReturns404NotFound() {
        Request request = new RequestParser("GET /dan_is_cool HTTP/1.1").buildRequest();
        Assert.assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", notFoundResourceHandler.handle(request).format());
    }
}
