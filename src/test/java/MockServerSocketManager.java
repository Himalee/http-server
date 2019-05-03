import java.io.*;

public class MockServerSocketManager implements SocketManager {

    private boolean connectCalled = false;
    private ByteArrayOutputStream output;
    private String request;

    public MockServerSocketManager(String request, ByteArrayOutputStream output) {
        this.output = output;
        this.request = request;
    }

    public void connect(int port) {
        connectCalled = true;
    }

    public boolean wasConnectCalled() {
        return connectCalled;
    }

    public CommunicationChannel communicationChannel() {
        return new CommunicationChannel(request, output);
    }

}
