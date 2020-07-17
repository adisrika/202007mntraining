package mnday4;

import io.micronaut.context.event.ShutdownEvent;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;

import javax.inject.Singleton;

@Singleton
public class MyInitializer {

    @EventListener
    public void init(StartupEvent event) {
        //
    }

    @EventListener
    public void abc(ShutdownEvent event) {
        //
    }

    @EventListener
    public void handleMyEvent(MyEvent myEvent) {
        System.out.println("MyEvent received");
    }


}
