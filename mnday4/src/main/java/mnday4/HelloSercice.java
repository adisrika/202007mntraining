package mnday4;

import io.micronaut.context.annotation.Executable;
import io.micronaut.context.event.ApplicationEventPublisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.function.Function;

@Singleton
@MyMethod
public class HelloSercice {

    @Inject
    ApplicationEventPublisher eventPublisher;

    @Executable
    public String sayHello() {
        eventPublisher.publishEvent(new MyEvent());
        return "Hello";
    }

    @Executable
    public String sayHi() {
        return "Hi";
    }


    //Function<Integer, String> transform = number -> number.toString();
    //
}
