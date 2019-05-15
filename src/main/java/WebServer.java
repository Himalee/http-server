import java.io.*;
import java.util.List;

public class WebServer {

    private SocketManager serverSocketManager;
    private RequestReader requestReader;
    private ResponseHandler responseHandler;
    private ServerStatus serverStatus;
    private CommunicationChannel serverCommunicationChannel;
    private HandlerAssembler handlerAssembler = new HandlerAssembler();

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
        responseBuilder = new ResponseBuilder();
        String request = request();
        if (request.equals(SIMPLE_GET_REQUEST)) {
            responseHandler.respond(output, responseBuilder.okayWithEmptyBody());
        } else if (request.contains(SIMPLE_HEAD_REQUEST)) {
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
