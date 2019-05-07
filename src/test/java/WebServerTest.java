import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;

public class WebServerTest {

    private int port = 1234;
    private MockServerSocketManager mockServerSocketManager;
    private RequestHandler requestHandler = new RequestHandler();
    private OutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUp() throws IOException {
        String simpleGetRequest = "GET /simple_get HTTP/1.1";
        InputStream input = new ByteArrayInputStream(simpleGetRequest.getBytes());
        mockServerSocketManager = new MockServerSocketManager(input, output);
        WebServer webServer = new WebServer(mockServerSocketManager, requestHandler);
        webServer.start(port);
    }

    @Test
    public void startWebServer_checkConnection() {
        Assert.assertTrue(mockServerSocketManager.wasConnectCalled());
    }

    @Test
    public void startWebServer_200ResponseWithSimpleGetUrl() {
        Assert.assertThat(output.toString(), containsString("HTTP/1.1 200 OK"));
    }
}
