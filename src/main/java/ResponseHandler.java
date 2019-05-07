import java.io.IOException;
import java.io.OutputStream;

public class ResponseHandler {

    public void prepare(OutputStream output, String statusLine) throws IOException {
        output.write(statusLine.getBytes("ASCII"));
        output.flush();
    }
}
