package server.response;

import java.io.IOException;
import java.io.OutputStream;

public class ResponseHandler {

    public void respond(OutputStream output, Response response) throws IOException {
        output.write(response.format().getBytes("ASCII"));
        output.flush();
    }
}
