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
        Assert.assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", notFoundResourceHandler.handle(request));
    }

    @Test
    public void getRequestWithInvalidUrlReturnsNoResponse() {
        Request request = new RequestParser("GET /not_found_resources HTTP/1.1").buildRequest();
        Assert.assertEquals("", notFoundResourceHandler.handle(request));
    }

    @Test
    public void requestWithInvalidHttpMethodReturnsNoResponse() {
        Request request = new RequestParser("HEAD /not_found_resource HTTP/1.1").buildRequest();
        Assert.assertEquals("", notFoundResourceHandler.handle(request));
    }
}
