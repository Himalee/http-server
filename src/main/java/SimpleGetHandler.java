public class SimpleGetHandler implements Handler {
    public String handle(String request) {
        StringBuilder response = new StringBuilder();
        if ((request.contains("simple_get")) && (request.contains("HEAD") || request.contains("GET"))) {
            response.append(new ResponseBuilder().okayWithEmptyBody());
        }
        return response.toString();
    }
}
