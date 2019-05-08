import java.io.*;

public class WebServer {

    private SocketManager serverSocketManager;
    private RequestHandler requestHandler;
    private ResponseHandler responseHandler;
    private static final String RESPONSE_STATUS_CODE_200 = "HTTP/1.1 200 OK\n";
    private static final String SIMPLE_GET_URL = "simple_get";

    public WebServer(SocketManager serverSocketManager, RequestHandler requestHandler, ResponseHandler responseHandler) {
        this.serverSocketManager = serverSocketManager;
        this.requestHandler = requestHandler;
        this.responseHandler = responseHandler;
    }

    public void start(int port) throws IOException {
        serverSocketManager.listen(port);
        serverSocketManager.connect();
        respond();
    }

    private CommunicationChannel communicationChannel() {
        return serverSocketManager.communicationChannel();
    }

    private void respond() throws IOException {
        OutputStream output = communicationChannel().getOutputStream();
       if (request().contains(SIMPLE_GET_URL)) {
           responseHandler.respond(output, RESPONSE_STATUS_CODE_200);
       }
       closeSocket(output);
    }

    private String request() throws IOException {
       return requestHandler.read(communicationChannel().getInputStream());
    }

    private void closeSocket(OutputStream outputStream) throws IOException {
        outputStream.close();
    }
}
