import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;

public class WebServerTest {

    private int port = 1234;
    private MockServerSocketManager mockServerSocketManager;
    private RequestHandler requestHandler = new RequestHandler();
    private ResponseHandler responseHandler = new ResponseHandler();
    private ServerStatus mockWebServerStatus = new MockWebServerStatus();
    private WebServer webServer;

    public void setUp(String request) throws IOException {
        CommunicationChannel mockServerCommunicationChannel = new MockServerCommunicationChannel(request);
        mockServerSocketManager = new MockServerSocketManager(mockServerCommunicationChannel);
        webServer = new WebServer(mockServerSocketManager, requestHandler, responseHandler, mockWebServerStatus);
        webServer.start(port);
    }

    @Test
    public void startWebServerListenForConnections() throws IOException {
        setUp("GET /simple_get HTTP/1.1");
        Assert.assertTrue(mockServerSocketManager.wasListenCalled());
    }

    @Test
    public void startWebServerGet200ResponseWithSimpleGetUrl() throws IOException {
        setUp("GET /simple_get HTTP/1.1");
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK"));
    }

    @Test
    public void startWebServerGet200ResponseWithSimpleHeadUrl() throws IOException {
        setUp("HEAD /simple_get HTTP/1.1");
        OutputStream response = mockServerSocketManager.acceptConnection().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK"));
    }
}
