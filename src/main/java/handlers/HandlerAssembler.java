package handlers;

import java.util.Arrays;
import java.util.List;

public final class HandlerAssembler {

    public static final List<Handler> GET_ALL_HANDLERS = Arrays.asList(
            new SimpleGetHandler(),
            new GetWithBodyHandler(),
            new MethodOptionsHandler(),
            new MethodOptionsTwoHandler(),
            new NotFoundResourceHandler(),
            new RedirectHandler(),
            new EchoBodyHandler(),
            new WelcomeHandler());
}
