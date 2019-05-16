public class MethodOptionsTwoHandler implements Handler {

    private static final String METHOD_OPTIONS_TWO_URL = "/method_options2";
    private static final String OPTIONS_REQUEST = "OPTIONS";

    public String handle(RequestParser request) {
        StringBuilder response = new StringBuilder();
        boolean requestContainsValidHttpMethod = (request.getHttpMethod().equals(OPTIONS_REQUEST));
        boolean requestContainsValidUrl = request.getUrl().equals(METHOD_OPTIONS_TWO_URL);
        if ((requestContainsValidUrl) && requestContainsValidHttpMethod) {
            response.append(new ResponseBuilder().okayWithHeadersGetHeadOptionsPutPost());
        }
        return response.toString();
    }
}
