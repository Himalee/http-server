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
        String request = request();
        String response = getResponse(new RequestParser(request));
        responseHandler.respond(output, response);
        closeSocket(output);
    }

    private String request() throws IOException {
        return requestReader.read(serverCommunicationChannel.getInputStream());
    }

    private void closeSocket(OutputStream outputStream) throws IOException {
        outputStream.close();
    }

    private String getResponse(RequestParser requestParser) {
        StringBuilder response = new StringBuilder();
        List handlers = handlerAssembler.getAllHandlers();
        for (Object handler : handlers) {
            response.append(((Handler)handler).handle(requestParser));
        }
        return response.toString();
    }
}
