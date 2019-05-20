package Server;

import java.io.IOException;

public interface SocketManager {
    CommunicationChannel acceptConnection() throws IOException;
    void listen(int port) throws IOException;
}
