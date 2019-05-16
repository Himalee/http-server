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
        return new ResponseBuilder().okayWithEmptyBody();
    }
}
