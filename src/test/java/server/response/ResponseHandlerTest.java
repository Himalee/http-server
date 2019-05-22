package server.response;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ResponseHandlerTest {
    @Test
    public void outputStreamWriteResponseMessage() throws IOException {
        ResponseHandler responseHandler = new ResponseHandler();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String responseMessage = "hello world";
        responseHandler.respond(output, responseMessage);
        byte[] byteArray = output.toByteArray();
        Assert.assertEquals("hello world", new String(byteArray));
    }
}
