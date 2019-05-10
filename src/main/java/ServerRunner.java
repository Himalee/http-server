import java.io.IOException;

public class ServerRunner {
    public static void main(String[] args) throws IOException {
        SocketManager serverSocketManager = new ServerSocketManager();
        RequestHandler requestHandler = new RequestHandler();
        ResponseHandler responseHandler = new ResponseHandler();
        ServerStatusInterface serverStatus = new ServerStatus();
        WebServer webServer = new WebServer(serverSocketManager, requestHandler, responseHandler, serverStatus);
        webServer.start(5000);
    }
}
