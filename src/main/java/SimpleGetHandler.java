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
    public String buildResponse() {
        return new ResponseBuilder().okayWithEmptyBody();
    }
}
