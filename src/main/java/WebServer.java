import java.io.*;

public class WebServer {

    private SocketManager serverSocketManager;
    private RequestHandler requestHandler;

    public WebServer(SocketManager serverSocketManager, RequestHandler requestHandler) {
        this.serverSocketManager = serverSocketManager;
        this.requestHandler = requestHandler;
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
       if (handleRequest().contains("simple_get")) {
           String statusLine = "HTTP/1.1 200 OK\r\n";
           output.write(statusLine.getBytes("ASCII"));
           output.flush();
       }
        output.close();
    }

    private String handleRequest() throws IOException {
       return requestHandler.read(communicationChannel().getInput());
    }
}
