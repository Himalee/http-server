import java.io.InputStream;
import java.io.OutputStream;

public class CommunicationChannel {

    private final OutputStream output;
    private final InputStream input;

    public CommunicationChannel(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    public OutputStream getOutput() {
        return output;
    }

    public InputStream getInput() {
        return input;
    }
}
