import Server.CommunicationChannel;
import Server.SocketManager;

public class MockServerSocketManager implements SocketManager {

    private boolean listenCalled = false;
    private CommunicationChannel communicationChannel;

    public MockServerSocketManager(CommunicationChannel communicationChannel) {
        this.communicationChannel = communicationChannel;
    }

    public void listen(int port) {
        listenCalled = true;
    }

    public CommunicationChannel acceptConnection() {
        return communicationChannel;
    }

    public boolean wasListenCalled() {
        return listenCalled;
    }
}
