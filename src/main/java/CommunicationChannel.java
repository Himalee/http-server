import java.io.InputStream;
import java.io.OutputStream;

public class CommunicationChannel implements CommunicationChannelInterface {

    private final OutputStream output;
    private final InputStream input;

    public CommunicationChannel(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    public OutputStream getOutputStream() {
        return output;
    }

    public InputStream getInputStream() {
        return input;
    }
}
