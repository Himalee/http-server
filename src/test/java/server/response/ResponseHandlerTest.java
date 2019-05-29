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
        Response response = new Response("hello ", "world ", "goodbye");
        responseHandler.respond(output, response);
        byte[] byteArray = output.toByteArray();
        Assert.assertEquals("hello world goodbye", new String(byteArray));
    }
}
