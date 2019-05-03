import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;

public class WebServerTest {

    private int port = 1234;
    private MockServerSocketManager mockServerSocketManager;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUp() throws IOException {
        mockServerSocketManager = new MockServerSocketManager(output);
        WebServer webServer = new WebServer(mockServerSocketManager);
        webServer.start(port);
    }

    @Test
    public void startWebServer_checkConnection() {
        Assert.assertTrue(mockServerSocketManager.wasConnectCalled());
    }

    @Test
    public void startWebServer_200ResponseWithAnyUrl() {
        Assert.assertThat(output.toString(), containsString("HTTP/1.1 200 OK"));
    }
}
