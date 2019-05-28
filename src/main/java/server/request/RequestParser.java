package server.request;

import server.HTTPMethod;

public class RequestParser {

    private String request;
    private static final int GET_FIRST_ELEMENT = 0;
    private static final int GET_SECOND_ELEMENT = 1;
    private static final String NEW_LINE = "\n";
    private static final int LIMIT_OF_TWO = 2;
    private static final String BLANK_SPACE = " ";


    public RequestParser(String request) {
        this.request = request;
    }

    public String getHttpMethod() {
        return getRequestLine()[GET_FIRST_ELEMENT];
    }

    public String getUrl() {
        return getRequestLine()[GET_SECOND_ELEMENT];
    }

    public String getBody() {
        String[] lines = request.split(NEW_LINE);
        if (getHttpMethod().equals(HTTPMethod.POST)) {
            int lastLine = lines.length - 1;
            return lines[lastLine];
        }
        return "";
    }

    private String[] getRequestLine() {
        String[] result = request.split(NEW_LINE, LIMIT_OF_TWO);
        return result[GET_FIRST_ELEMENT].split(BLANK_SPACE);
    }
}
