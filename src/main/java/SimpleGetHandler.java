public class SimpleGetHandler implements Handler {

    private static final String SIMPLE_GET_URL = "/simple_get";
    private static final String GET_REQUEST = "GET";
    private static final String HEAD_REQUEST = "HEAD";

    public String handle(RequestParser request) {
        StringBuilder response = new StringBuilder();
        boolean requestContainsValidHttpMethod = (request.getHttpMethod().equals(GET_REQUEST) || request.getHttpMethod().equals(HEAD_REQUEST));
        boolean requestContainsValidUrl = request.getUrl().equals(SIMPLE_GET_URL);
        if ((requestContainsValidUrl) && requestContainsValidHttpMethod) {
            response.append(new ResponseBuilder().okayWithEmptyBody());
        }
        return response.toString();
    }
}
