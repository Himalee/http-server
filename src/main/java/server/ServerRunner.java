package server;

import server.request.RequestReader;
import server.response.ResponseHandler;

import java.io.IOException;

public class ServerRunner {
    public static void main(String[] args) throws IOException {
        SocketManager serverSocketManager = new ServerSocketManager();
        RequestReader requestReader = new RequestReader();
        ResponseHandler responseHandler = new ResponseHandler();
        ServerStatus serverStatus = new WebServerStatus();
        WebServer webServer = new WebServer(serverSocketManager, requestReader, responseHandler, serverStatus);
        webServer.start(5000);
    }
}
