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
        return new ResponseBuilder().okayWithHeadersGetHeadOptionsPutPost();
    }
}
