package server.request;

public class Request {
    private String httpMethod;
    private String url;
    private String body;

    public Request(String httpMethod, String url, String body) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.body = body;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public String getBody() {
        return body;
    }
}
