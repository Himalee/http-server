public class ResponseBuilder {
    private static final String EMPTY_BODY_OUTPUT = "";
    private static final String STATUS_CODE_OK = "HTTP/1.1 200 OK\r\n";
    private static final String OUTPUT_END_OF_HEADERS = "\r\n";

    public String okayWithEmptyBody() {
        return STATUS_CODE_OK + OUTPUT_END_OF_HEADERS + EMPTY_BODY_OUTPUT;
    }

    public String okayWithNoBody() {
        return STATUS_CODE_OK + OUTPUT_END_OF_HEADERS;
    }
}
