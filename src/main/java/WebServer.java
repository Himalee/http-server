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

    private CommunicationChannel communicationChannel() {
        return serverSocketManager.communicationChannel();
    }

    private void prepareResponse() throws IOException {
        OutputStream output = communicationChannel().getOutput();
       if (serverSocketManager.communicationChannel().getRequest().contains("simple_get")) {
           String statusLine = "HTTP/1.1 200 OK\r\n";
           output.write(statusLine.getBytes("ASCII"));
           output.flush();
       }
        output.close();
    }
}
