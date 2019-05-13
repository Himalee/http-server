import java.io.*;

public class WebServer {

    private SocketManager serverSocketManager;
    private RequestHandler requestHandler;
    private ResponseHandler responseHandler;
    private ResponseBuilder responseBuilder;
    private ServerStatus serverStatus;
    private CommunicationChannel serverCommunicationChannel;
    private static final String SIMPLE_GET_REQUEST = "GET /simple_get HTTP/1.1";

    public WebServer(SocketManager serverSocketManager, RequestHandler requestHandler, ResponseHandler responseHandler, ServerStatus serverStatus) {
        this.serverSocketManager = serverSocketManager;
        this.requestHandler = requestHandler;
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
        if (request().contains(SIMPLE_GET_REQUEST)) {
            responseBuilder = new ResponseBuilder();
            responseHandler.respond(output, responseBuilder.okayWithEmptyBody());
        }
        closeSocket(output);
    }

    private String request() throws IOException {
        return requestHandler.read(serverCommunicationChannel.getInputStream());
    }

    private void closeSocket(OutputStream outputStream) throws IOException {
        outputStream.close();
    }
}
