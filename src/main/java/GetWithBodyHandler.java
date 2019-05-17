import java.util.Arrays;
import java.util.List;

public class GetWithBodyHandler extends Handler {

    @Override
    public String url() {
        return "/get_with_body";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList("HEAD");
    }

    @Override
    public String buildResponse() {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 200 OK\r\n\r\n").setHeaders("").setBody("").build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
