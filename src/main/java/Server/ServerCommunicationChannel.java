package Server;

import java.io.InputStream;
import java.io.OutputStream;

public class ServerCommunicationChannel implements CommunicationChannel {

    private final OutputStream output;
    private final InputStream input;

    public ServerCommunicationChannel(InputStream input, OutputStream output) {
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
