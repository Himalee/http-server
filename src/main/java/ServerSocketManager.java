import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketManager implements SocketManager {

    private ServerSocket serverSocket;

    public void listen(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public CommunicationChannel acceptConnection() throws IOException {
        Socket socket = serverSocket.accept();
        return new ServerCommunicationChannel(socket.getInputStream(), socket.getOutputStream());
    }
}

