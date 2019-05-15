public class RequestParser {

    private String request;
    static final int GET_FIRST_ELEMENT = 0;
    static final int GET_SECOND_ELEMENT = 1;

    public RequestParser(String request) {
        this.request = request;
    }

    public String getHttpMethod() {
        return getRequestLine()[GET_FIRST_ELEMENT];
    }

    public String getUrl() {
        return getRequestLine()[GET_SECOND_ELEMENT];
    }

    private String[] getRequestLine() {
        String[] result = request.split("\n", 2);
        return result[0].split(" ");
    }
}
