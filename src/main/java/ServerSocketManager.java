import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketManager implements SocketManager {

    private CommunicationChannel serverCommunicationChannel;
    private ServerSocket serverSocket;

    public void listen(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void connect() throws IOException {
        Socket socket = serverSocket.accept();
        serverCommunicationChannel = new ServerCommunicationChannel(socket.getInputStream(), socket.getOutputStream());
    }

    public CommunicationChannel communicationChannel() {
        return serverCommunicationChannel;
    }
}

