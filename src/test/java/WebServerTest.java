import Server.*;
import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void startWebServerListenForConnections() throws IOException {
        WebServer webServer = buildServerSendRequest("GET /simple_get HTTP/1.1");
        webServer.start(port);
        Assert.assertTrue(mockServerSocketManager.wasListenCalled());
    }

    @Test
    public void startWebServerGet200ResponseWithGetRequestAndSimpleGetUrl() throws IOException {
        WebServer webServer = buildServerSendRequest("GET /simple_get HTTP/1.1");
        webServer.start(port);
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK"));
    }

    @Test
    public void startWebServerGet200ResponseWithHeadRequestAndSimpleGetUrl() throws IOException {
        WebServer webServer = buildServerSendRequest("HEAD /simple_get HTTP/1.1");
        webServer.start(port);
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK"));
    }

    @Test
    public void startWebServerGet200ResponseWithHeadRequestAndGetWithBodyUrl() throws IOException {
        WebServer webServer = buildServerSendRequest("HEAD /get_with_body HTTP/1.1");
        webServer.start(port);
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK"));
    }

    @Test
    public void startWebServerGet200ResponseWithOptionsRequestAndMethodOptionsUrl() throws IOException {
        WebServer webServer = buildServerSendRequest("OPTIONS /method_options HTTP/1.1");
        webServer.start(port);
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS"));
    }

    @Test
    public void startWebServerGet200ResponseWithOptionsRequestAndMethodOptionsTwoUrl() throws IOException {
        WebServer webServer = buildServerSendRequest("OPTIONS /method_options2 HTTP/1.1");
        webServer.start(port);
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST"));
    }

    @Test
    public void startWebServerGet404ResponseWithGetRequestAndNotFoundResourceUrl() throws IOException {
        WebServer webServer = buildServerSendRequest("GET /not_found_resource HTTP/1.1");
        webServer.start(port);
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 404 Not Found"));
    }

    @Test
    public void startWebServerGet301ResponseWithGetRequestAndRedirectUrl() throws IOException {
        WebServer webServer = buildServerSendRequest("GET /redirect HTTP/1.1");
        webServer.start(port);
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 301 Moved Permanently\r\nLocation: http://127.0.0.1:5000/simple_get"));
    }
}
