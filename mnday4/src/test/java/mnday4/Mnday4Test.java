package mnday4;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
public class Mnday4Test {

    @Inject
    EmbeddedApplication application;

    @Inject
    HelloSercice helloSercice;

    @Inject
    MyProcessor myProcessor;

    @Inject
    MyService myService;

    @Inject
    Latte latte;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void name() {
        helloSercice.sayHello();
    }

    @Test
    void testExecuteAround() {
        String result = myService.doSomething();
        System.out.println(result);
        Assertions.assertEquals("Done", result);
    }

    @Test
    void testIntroAdvice() {
        Assertions.assertEquals("LATTE", latte.getCoffee().getName());
    }
}
