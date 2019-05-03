import java.io.*;

public class WebServer {

    private SocketManager serverSocketManager;

    public WebServer(SocketManager serverSocketManager) {
        this.serverSocketManager = serverSocketManager;
    }

    public void start(int port) throws IOException {
        serverSocketManager.connect(port);
        prepareResponse();
    }

    public CommunicationChannel communicationChannel() {
        return serverSocketManager.communicationChannel();
    }

    public void prepareResponse() throws IOException {
        OutputStream output = communicationChannel().getOutput();
        String statusLine = "HTTP/1.1 200 OK\r\n";
        output.write(statusLine.getBytes("ASCII"));
        output.flush();
        output.close();
    }
}
