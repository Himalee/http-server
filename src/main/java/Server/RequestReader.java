package Server;

import java.io.IOException;
import java.io.InputStream;

public class RequestReader {

    public String read(InputStream inputStream) throws IOException {
        StringBuilder result = new StringBuilder();
        do {
            result.append((char) inputStream.read());
        } while (inputStream.available() > 0);
        return result.toString();
    }
}
