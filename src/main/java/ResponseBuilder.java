public class ResponseBuilder {

    private static final String EMPTY_BODY_OUTPUT = "";
    private static final String STATUS_CODE_OK = "HTTP/1.1 200 OK";
    private static final String CRLF = "\r\n";
    private static final String ALLOWED_HEADER = "Allow: ";
    private static final String GET_HEAD_OPTIONS = "GET, HEAD, OPTIONS";
    private static final String PUT_AND_POST = ", PUT, POST";

    public String okayWithEmptyBody() {
        return STATUS_CODE_OK + CRLF + CRLF + EMPTY_BODY_OUTPUT;
    }

    public String okayWithHeadersGetHeadOptions() {
        return STATUS_CODE_OK + CRLF + ALLOWED_HEADER + GET_HEAD_OPTIONS + CRLF + CRLF + EMPTY_BODY_OUTPUT;
    }

    public String okayWithHeadersGetHeadOptionsPutPost() {
        return STATUS_CODE_OK + CRLF + ALLOWED_HEADER + GET_HEAD_OPTIONS + PUT_AND_POST + CRLF + CRLF + EMPTY_BODY_OUTPUT;
    }
}
