import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketManager implements SocketManager {

    private CommunicationChannel communicationChannel;

    public void connect(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        communicationChannel = new CommunicationChannel(socket.getOutputStream());
    }

    public CommunicationChannel communicationChannel() {
        return communicationChannel;
    }
}
