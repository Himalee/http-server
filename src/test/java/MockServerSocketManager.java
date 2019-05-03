import java.io.*;

public class MockServerSocketManager implements SocketManager {

    private boolean connectCalled = false;
    private ByteArrayOutputStream output;

    public MockServerSocketManager(ByteArrayOutputStream output) {
        this.output = output;
    }

    public void connect(int port) {
        connectCalled = true;
    }

    public boolean wasConnectCalled() {
        return connectCalled;
    }

    public CommunicationChannel communicationChannel() {
        return new CommunicationChannel(output);
    }
}
