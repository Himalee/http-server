public class MethodOptionsHandler implements Handler {

    private static final String METHOD_OPTIONS_URL = "/method_options";
    private static final String OPTIONS_REQUEST = "OPTIONS";

    public String handle(RequestParser request) {
        StringBuilder response = new StringBuilder();
        boolean requestContainsValidHttpMethod = (request.getHttpMethod().equals(OPTIONS_REQUEST));
        boolean requestContainsValidUrl = request.getUrl().equals(METHOD_OPTIONS_URL);
        if ((requestContainsValidUrl) && requestContainsValidHttpMethod) {
            response.append(new ResponseBuilder().okayWithHeadersGetHeadOptions());
        }
        return response.toString();
    }
}
