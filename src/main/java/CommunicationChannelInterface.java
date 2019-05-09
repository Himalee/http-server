import java.io.InputStream;
import java.io.OutputStream;

public interface CommunicationChannelInterface {
    OutputStream getOutputStream();
    InputStream getInputStream();
}
