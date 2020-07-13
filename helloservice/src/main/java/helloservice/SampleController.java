package helloservice;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Controller("/")
public class SampleController {

    @Inject
    private HelloService helloService;

    public static final Logger LOGGER =
            LoggerFactory.getLogger(SampleController.class);

    @Get("/regularType")
    @Produces(MediaType.TEXT_PLAIN)
    public String regularType() {
        LOGGER.info("regularType");
        return helloService.getMessageRx();
    }

    @Get("/reactiveType")
    @Produces(MediaType.TEXT_PLAIN)
    @ExecuteOn(TaskExecutors.IO)
    public Single<String> reactiveType(){
        LOGGER.info("reactiveType");
        return Single.just("Hello");
    }

}
