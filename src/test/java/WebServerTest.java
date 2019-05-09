import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;

public class WebServerTest {

    private int port = 1234;
    private MockServerSocketManager mockServerSocketManager;
    private RequestHandler requestHandler = new RequestHandler();
    private CommunicationChannelInterface mockCommunicationChannel = new MockCommunicationChannel();
    private ResponseHandler responseHandler = new ResponseHandler();
    private WebServer webServer;

    @Before
    public void setUp() throws IOException {
        mockServerSocketManager = new MockServerSocketManager(mockCommunicationChannel);
        webServer = new WebServer(mockServerSocketManager, requestHandler, responseHandler);
        webServer.start(port);
    }

    @Test
    public void startWebServerListenForConnections() {
        Assert.assertTrue(mockServerSocketManager.wasListenCalled());
    }

    @Test
    public void startWebServerCheckConnection() {
        Assert.assertTrue(mockServerSocketManager.wasConnectCalled());
    }

    @Test
    public void startWebServerGet200ResponseWithSimpleGetUrl() {
        OutputStream response = mockServerSocketManager.communicationChannel().getOutputStream();
        Assert.assertThat(response.toString(), containsString("HTTP/1.1 200 OK"));
    }
}
