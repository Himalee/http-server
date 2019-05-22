package server;

public class WebServerStatus implements ServerStatus {

    private boolean keepAcceptingConnections = true;

    public boolean acceptConnections() {
        return keepAcceptingConnections;
    }
}
