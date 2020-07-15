package shoppingservice;

import io.micronaut.retry.annotation.Recoverable;

import javax.inject.Singleton;

@Singleton
@Recoverable(api = MyProcessor.class)
public class MyProcessorImpl implements MyProcessor {
    @Override
    public void process() {
        throw new RuntimeException();
    }
}
