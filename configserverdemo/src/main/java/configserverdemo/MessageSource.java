package configserverdemo;

import io.micronaut.context.annotation.Property;
import io.micronaut.runtime.context.scope.Refreshable;

@Refreshable
public class MessageSource {
    @Property(name = "greeting.message")
    private String message;

    public String getMessage() {
        return message;
    }
}
