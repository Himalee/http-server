import Server.ServerStatus;

public class MockWebServerStatus implements ServerStatus {

    private boolean keepAcceptingConnections = true;
    private int connectionsCounter = 0;

    public boolean acceptConnections() {
        if (connectionsCounter < 1) {
            connectionsCounter ++;
            keepAcceptingConnections = true;
        } else {
            keepAcceptingConnections = false;
        }
        return keepAcceptingConnections;
    }
}
