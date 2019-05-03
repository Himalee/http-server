import java.io.OutputStream;

public class CommunicationChannel {

    private final OutputStream output;

    public CommunicationChannel(OutputStream output) {
        this.output = output;
    }

    public OutputStream getOutput() {
        return output;
    }
}
