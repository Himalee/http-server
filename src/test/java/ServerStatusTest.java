import org.junit.Assert;
import org.junit.Test;

public class ServerStatusTest {
    @Test
    public void statusAlwaysListening() {
        ServerStatus serverStatus = new ServerStatus();
        Assert.assertEquals(true, serverStatus.acceptConnections());
    }
}
