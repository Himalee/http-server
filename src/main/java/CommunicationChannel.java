import java.io.OutputStream;

public class CommunicationChannel {

    private final OutputStream output;
    private final String request;

    public CommunicationChannel(String request, OutputStream output) {
        this.request = request;
        this.output = output;
    }

    public OutputStream getOutput() {
        return output;
    }

    public String getRequest() {
        return request;
    }
}
