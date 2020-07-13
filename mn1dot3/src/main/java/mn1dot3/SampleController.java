package mn1dot3;

import io.micronaut.core.annotation.Blocking;
import io.micronaut.core.annotation.NonBlocking;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/")
public class SampleController {

    public static final Logger LOGGER =
            LoggerFactory.getLogger(SampleController.class);

    @Get("/regularType")
    @Produces(MediaType.TEXT_PLAIN)
    public String regularType() {
        LOGGER.info("regularType");
        return "Hello";
    }

    @Get("/reactiveType")
    @Produces(MediaType.TEXT_PLAIN)
    public Single<String> reactiveType(){
        LOGGER.info("reactiveType");
        return Single.just("Hello");
    }

    @Get("/regularTypeNB")
    @Produces(MediaType.TEXT_PLAIN)
    @NonBlocking
    public String regularTypeNB() {
        LOGGER.info("regularType");
        return "Hello";
    }

    @Get("/reactiveTypeBlk")
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    public Single<String> reactiveTypeBlk(){
        LOGGER.info("reactiveType");
        return Single.just("Hello");
    }
}
