package server.response;

public class ResponseBuilder {

    private String statusCode;
    private String headers;
    private String body;

    public ResponseBuilder setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public ResponseBuilder setHeaders(String headers) {
        this.headers = headers;
        return this;
    }

    public ResponseBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public Response build() {
        return new Response(statusCode, headers, body);
    }
}
