import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RequestHandlerTest {

    @Test
    public void outputStreamReadRequest() throws IOException {
        RequestHandler requestHandler = new RequestHandler();
        String myString = "hello world";
        InputStream request = new ByteArrayInputStream(myString.getBytes());

        Assert.assertEquals("hello world", requestHandler.read(request));
    }
}
