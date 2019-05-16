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
        return new ResponseBuilder().notFound();
    }
}
