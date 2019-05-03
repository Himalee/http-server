import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketManager implements SocketManager {

    private CommunicationChannel communicationChannel;

    public void connect(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        InputStream input = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(input);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String request = bufferedReader.readLine();

        communicationChannel = new CommunicationChannel(request, socket.getOutputStream());
    }

    public CommunicationChannel communicationChannel() {
        return communicationChannel;
    }
}
