package server;

import server.request.Request;
import server.request.RequestParser;
import server.request.RequestReader;
import server.response.ResponseHandler;

import java.io.*;

public class WebServer {

    private SocketManager serverSocketManager;
    private RequestReader requestReader;
    private ResponseHandler responseHandler;
    private ServerStatus serverStatus;
    private CommunicationChannel serverCommunicationChannel;

    public WebServer(SocketManager serverSocketManager, RequestReader requestReader, ResponseHandler responseHandler, ServerStatus serverStatus) {
        this.serverSocketManager = serverSocketManager;
        this.requestReader = requestReader;
        this.responseHandler = responseHandler;
        this.serverStatus = serverStatus;
    }

    public void start(int port) throws IOException {
        serverSocketManager.listen(port);
        while (serverStatus.acceptConnections()) {
            respond();
        }
    }

    private void respond() throws IOException {
        serverCommunicationChannel = serverSocketManager.acceptConnection();
        OutputStream output = serverCommunicationChannel.getOutputStream();
        String rawRequest = request();
        Request request = new RequestParser(rawRequest).buildRequest();
        String response = new RouteHandler().buildResponse(request);
        responseHandler.respond(output, response);
        closeSocket(output);
    }

    private String request() throws IOException {
        return requestReader.read(serverCommunicationChannel.getInputStream());
    }

    private void closeSocket(OutputStream outputStream) throws IOException {
        outputStream.close();
    }
}
