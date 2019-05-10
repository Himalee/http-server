public class MockServerSocketManager implements SocketManager {

    private boolean listenCalled = false;
    private boolean connectCalled = false;
    private CommunicationChannel communicationChannel;

    public MockServerSocketManager(CommunicationChannel communicationChannel) {
        this.communicationChannel = communicationChannel;
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
        return communicationChannel;
    }
}
