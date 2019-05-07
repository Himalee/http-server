import java.io.*;

public class MockServerSocketManager implements SocketManager {

    private boolean connectCalled = false;
    private OutputStream output;
    private InputStream input;

    public MockServerSocketManager(InputStream input, OutputStream output) {
        this.output = output;
        this.input = input;
    }

    public void connect(int port) {
        connectCalled = true;
    }

    public boolean wasConnectCalled() {
        return connectCalled;
    }

    public CommunicationChannel communicationChannel() {
        return new CommunicationChannel(input, output);
    }
}
