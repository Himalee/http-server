package server.request;

import server.HTTPMethod;

public class RequestParser {

    private String request;
    private static final int GET_FIRST_ELEMENT = 0;
    private static final int GET_SECOND_ELEMENT = 1;
    private static final String NEW_LINE = "\n";
    private static final String BLANK_SPACE = " ";


    public RequestParser(String request) {
        this.request = request;
    }

    public String httpMethod() {
        return getRequestLine()[GET_FIRST_ELEMENT];
    }

    public String url() {
        try {
            return getRequestLine()[GET_SECOND_ELEMENT];
        } catch (Exception ArrayIndexOutOfBoundsException) {
            return "";
        }
    }

    public String body() {
        String[] lines = request.split(NEW_LINE);
        if (httpMethod().equals(HTTPMethod.POST)) {
            int lastLine = lines.length - 1;
            return lines[lastLine];
        }
        return "";
    }

    public Request buildRequest() {
        return new Request(httpMethod(), url(), body());
    }

    private String[] getRequestLine() {
        String[] result = request.split(NEW_LINE);
        return result[GET_FIRST_ELEMENT].split(BLANK_SPACE);
    }
}
