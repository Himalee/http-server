import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MockServerCommunicationChannel implements CommunicationChannel {

    private OutputStream output = new ByteArrayOutputStream();
    private String request;

    public MockServerCommunicationChannel(String request) {
        this.request = request;
    }

    public OutputStream getOutputStream() {
        return output;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(request.getBytes());
    }
}
