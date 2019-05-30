package server;

import org.junit.Assert;
import org.junit.Test;
import server.request.RequestReader;
import server.response.ResponseHandler;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;

public class WebServerTest {

    private int port = 1234;
    private MockServerSocketManager mockServerSocketManager;
    private RequestReader requestReader = new RequestReader();
    private ResponseHandler responseHandler = new ResponseHandler();
    private ServerStatus mockWebServerStatus = new MockWebServerStatus();

    public WebServer buildServerSendRequest(String request) {
        CommunicationChannel mockServerCommunicationChannel = new MockServerCommunicationChannel(request);
        mockServerSocketManager = new MockServerSocketManager(mockServerCommunicationChannel);
        return new WebServer(mockServerSocketManager, requestReader, responseHandler, mockWebServerStatus);
    }

    public OutputStream serverResponse(String request) throws IOException {
        WebServer webServer = buildServerSendRequest(request);
        webServer.start(port);
        return mockServerSocketManager.acceptConnection().getOutputStream();
    }

    @Test
    public void startWebServerListenForConnections() throws IOException {
        WebServer webServer = buildServerSendRequest("GET /simple_get HTTP/1.1");
        webServer.start(port);
        Assert.assertTrue(mockServerSocketManager.wasListenCalled());
    }

    @Test
    public void startWebServerGet200ResponseWithGetRequestAndSimpleGetUrl() throws IOException {
        String request = "GET /simple_get HTTP/1.1";
        Assert.assertThat(serverResponse(request).toString(), containsString("HTTP/1.1 200 OK"));
    }

    @Test
    public void startWebServerGet200ResponseWithHeadRequestAndSimpleGetUrl() throws IOException {
        String request = "HEAD /simple_get HTTP/1.1";
        Assert.assertThat(serverResponse(request).toString(), containsString("HTTP/1.1 200 OK"));
    }

    @Test
    public void startWebServerGet200ResponseWithHeadRequestAndGetWithBodyUrl() throws IOException {
        String request = "HEAD /get_with_body HTTP/1.1";
        Assert.assertThat(serverResponse(request).toString(), containsString("HTTP/1.1 200 OK"));
    }

    @Test
    public void startWebServerGet200ResponseWithOptionsRequestAndMethodOptionsUrl() throws IOException {
        String request = "OPTIONS /method_options HTTP/1.1";
        Assert.assertThat(serverResponse(request).toString(), containsString("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS"));
    }

    @Test
    public void startWebServerGet200ResponseWithOptionsRequestAndMethodOptionsTwoUrl() throws IOException {
        String request = "OPTIONS /method_options2 HTTP/1.1";
        Assert.assertThat(serverResponse(request).toString(), containsString("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST"));
    }

    @Test
    public void startWebServerGet404ResponseWithGetRequestAndNotFoundResourceUrl() throws IOException {
        String request = "GET /not_found_resource HTTP/1.1";
        Assert.assertThat(serverResponse(request).toString(), containsString("HTTP/1.1 404 Not Found"));
    }

    @Test
    public void startWebServerGet301ResponseWithGetRequestAndRedirectUrl() throws IOException {
        String request = "GET /redirect HTTP/1.1";
        Assert.assertThat(serverResponse(request).toString(), containsString("HTTP/1.1 301 Moved Permanently\r\nLocation: " + System.getenv("REDIRECT_URL")));
    }

    @Test
    public void startWebServerGet404ResponseWithUnknownUrl() throws IOException {
        String request = "GET /unknown_url HTTP/1.1";
        Assert.assertThat(serverResponse(request).toString(), containsString("HTTP/1.1 404 Not Found"));
    }

    @Test
    public void startWebServerGet200ResponseWithEmptyUrl() throws IOException {
        String request = "GET / HTTP/1.1";
        Assert.assertThat(serverResponse(request).toString(), containsString("HTTP/1.1 200 OK"));
    }
}
