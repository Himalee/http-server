import java.io.IOException;

public class ServerRunner {
    public static void main(String[] args) throws IOException {
        SocketManager serverSocketManager = new ServerSocketManager();
        RequestHandler requestHandler = new RequestHandler();
        WebServer webServer = new WebServer(serverSocketManager, requestHandler);
        webServer.start(5000);
    }
}
