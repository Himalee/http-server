import java.io.IOException;

public class ServerRunner {
    public static void main(String[] args) throws IOException {
        SocketManager serverSocketManager = new ServerSocketManager();
        RequestHandler requestHandler = new RequestHandler();
        ResponseHandler responseHandler = new ResponseHandler();
        WebServer webServer = new WebServer(serverSocketManager, requestHandler, responseHandler);
        webServer.start(5000);
    }
}
