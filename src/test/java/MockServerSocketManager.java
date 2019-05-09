public class MockServerSocketManager implements SocketManager {

    private boolean listenCalled = false;
    private boolean connectCalled = false;
    private CommunicationChannelInterface communicationChannel;

    public MockServerSocketManager(CommunicationChannelInterface communicationChannel) {
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

    public CommunicationChannelInterface communicationChannel() {
        return communicationChannel;
    }
}
