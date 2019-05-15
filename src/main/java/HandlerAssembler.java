import java.util.ArrayList;
import java.util.List;

public class HandlerAssembler {
    public List getAllHandlers() {
        List<Handler> handlers = new ArrayList<>();
        handlers.add(new SimpleGetHandler());
        handlers.add(new GetWithBodyHandler());
        return handlers;
    }
}
