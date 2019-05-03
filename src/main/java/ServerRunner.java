import java.io.IOException;

public class ServerRunner {
    public static void main(String[] args) throws IOException {
        SocketManager serverSocketManager = new ServerSocketManager();
        WebServer webServer = new WebServer(serverSocketManager);
        webServer.start(5000);
    }
}
