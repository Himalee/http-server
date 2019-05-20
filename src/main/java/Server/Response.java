package Server;

public class Response {

    private String statusCode;
    private String headers;
    private String body;

    public Response(String statusCode, String headers, String body) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
}
