package configserverdemo;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import javax.inject.Inject;

@Controller("/")
public class HelloController {

    @Inject
    private MessageSource messageSource;

    @Get("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
        return messageSource.getMessage();
    }
}
