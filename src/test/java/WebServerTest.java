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
    public void startWebServerGet200ResponseWithSimpleGetUrl() throws IOException {
        WebServer webServer = buildServerSendRequest("GET /simple_get HTTP/1.1");
        webServer.start(port);
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK"));
    }

    @Test
    public void startWebServerGet200ResponseWithSimpleHeadUrl() throws IOException {
        WebServer webServer = buildServerSendRequest("HEAD /simple_get HTTP/1.1");
        webServer.start(port);
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK"));
    }
}
