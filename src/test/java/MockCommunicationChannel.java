import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MockCommunicationChannel implements CommunicationChannelInterface {

    private OutputStream output = new ByteArrayOutputStream();

    public OutputStream getOutputStream() {
        return output;
    }

    public InputStream getInputStream() {
        String simpleGetRequest = "GET /simple_get HTTP/1.1";
        return new ByteArrayInputStream(simpleGetRequest.getBytes());
    }
}
