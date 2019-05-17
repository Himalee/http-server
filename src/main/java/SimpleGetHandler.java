import java.util.Arrays;
import java.util.List;

public class SimpleGetHandler extends Handler {

    @Override
    public String url() {
        return "/simple_get";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList("GET", "HEAD");
    }

    @Override
    public String buildResponse(RequestParser request) {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 200 OK\r\n\r\n").setHeaders("").setBody("").build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
