package helloservice;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.env.Environment;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import javax.inject.Inject;

@Controller("/hello")
public class HelloController {

    @Inject
    private HelloService helloService;

    @Value("${greeting.message}")
    private String message;

    @Property(name = "greeting.message")
    private String message2;

    @Inject
    private Environment environment;

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        //return helloService.getMessage();
//        return environment.getProperty("greetig.message",
//                String.class).orElse("Hi");
        return message;
    }
}
