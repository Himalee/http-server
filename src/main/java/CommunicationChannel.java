import java.io.InputStream;
import java.io.OutputStream;

public interface CommunicationChannel {
    OutputStream getOutputStream();
    InputStream getInputStream();
}
