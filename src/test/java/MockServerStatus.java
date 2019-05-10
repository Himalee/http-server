public class MockServerStatus implements ServerStatusInterface {

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
