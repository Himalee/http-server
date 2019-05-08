import java.io.*;

public class MockServerSocketManager implements SocketManager {

    private boolean listenCalled = false;
    private boolean connectCalled = false;
    private OutputStream output;
    private InputStream input;

    public MockServerSocketManager(InputStream input, OutputStream output) {
        this.output = output;
        this.input = input;
    }

    public void listen(int port) {
        listenCalled = true;
    }

    public void connect() {
        connectCalled = true;
    }

    public boolean wasListenCalled() {
        return listenCalled;
    }

    public boolean wasConnectCalled() {
        return connectCalled;
    }

    public CommunicationChannel communicationChannel() {
        return new CommunicationChannel(input, output);
    }
}
