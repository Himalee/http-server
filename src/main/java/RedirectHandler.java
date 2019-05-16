import java.util.Arrays;
import java.util.List;

public class RedirectHandler extends Handler {

    private static final String REDIRECT_URL = "http://127.0.0.1:5000/simple_get";

    @Override
    public String url() {
        return "/redirect";
    }

    @Override
    public List<String> httpMethods() {
        return Arrays.asList("GET");
    }

    @Override
    public String buildResponse() {
        return new ResponseBuilder().redirectTo(REDIRECT_URL);
    }
}
