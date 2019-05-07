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
        serverSocketManager.connect(port);
        prepareResponse();
    }

    private CommunicationChannel communicationChannel() {
        return serverSocketManager.communicationChannel();
    }

    private void prepareResponse() throws IOException {
        OutputStream output = communicationChannel().getOutput();
       if (request().contains(SIMPLE_GET_URL)) {
           responseHandler.prepare(output, RESPONSE_STATUS_CODE_200);
       }
        output.close();
    }

    private String request() throws IOException {
       return requestHandler.read(communicationChannel().getInput());
    }
}
