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

//method: "POST"
//url: "simple_get"
//httpprtoto: "HTTP"
//headers: everything
//body: "some body"