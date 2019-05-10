public class ServerStatus implements ServerStatusInterface {

    private boolean keepAcceptingConnections = true;

    public boolean acceptConnections() {
        return keepAcceptingConnections;
    }
}
