import java.io.IOException;

public interface SocketManager {
    void connect() throws IOException;
    void listen(int port) throws IOException;
    CommunicationChannelInterface communicationChannel();
}
