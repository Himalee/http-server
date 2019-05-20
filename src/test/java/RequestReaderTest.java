import Server.RequestReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RequestReaderTest {

    @Test
    public void outputStreamReadRequest() throws IOException {
        RequestReader requestReader = new RequestReader();
        String myString = "hello world";
        InputStream request = new ByteArrayInputStream(myString.getBytes());

        Assert.assertEquals("hello world", requestReader.read(request));
    }
}
