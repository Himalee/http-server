import java.util.Arrays;
import java.util.List;

public class MethodOptionsTwoHandler extends Handler {

    @Override
    public String url() {
        return "/method_options2";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList("OPTIONS");
    }

    @Override
    public String buildResponse() {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 200 OK\r\n").setHeaders("Allow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n").setBody("").build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
