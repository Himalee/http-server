public class GetWithBodyHandler implements Handler {

    private static final String GET_WITH_BODY_URL = "/get_with_body";
    private static final String HEAD_REQUEST = "HEAD";

    public String handle(RequestParser request) {
        StringBuilder response = new StringBuilder();
        boolean requestContainsValidHttpMethod = request.getHttpMethod().equals(HEAD_REQUEST);
        boolean requestContainsValidUrl = request.getUrl().equals(GET_WITH_BODY_URL);
        if (requestContainsValidUrl && requestContainsValidHttpMethod) {
            response.append(new ResponseBuilder().okayWithEmptyBody());
        }
        return response.toString();
    }
}
