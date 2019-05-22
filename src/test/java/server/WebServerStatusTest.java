package server;

import org.junit.Assert;
import org.junit.Test;

public class WebServerStatusTest {
    @Test
    public void statusAlwaysListening() {
        WebServerStatus webServerStatus = new WebServerStatus();
        Assert.assertEquals(true, webServerStatus.acceptConnections());
    }
}
