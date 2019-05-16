import java.util.Arrays;
import java.util.List;

public class NotFoundResourceHandler extends Handler {

    @Override
    public String url() {
        return "/not_found_resource";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList("GET");
    }

    @Override
    public String buildResponse() {
        Response response = new ResponseBuilder().setStatusCode("HTTP/1.1 404 Not Found\r\n\r\n").setHeaders("").setBody("").build();
        return response.getStatusCode() + response.getHeaders() + response.getBody();
    }
}
