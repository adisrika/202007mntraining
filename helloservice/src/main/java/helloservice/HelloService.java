package helloservice;

import io.micronaut.scheduling.TaskExecutors;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.concurrent.ExecutorService;

@Singleton
public class HelloService {

    @Inject
    @Named(TaskExecutors.IO)
    ExecutorService executorService;

    public static final Logger LOGGER =
            LoggerFactory.getLogger(HelloService.class);

    @PostConstruct
    public void init() {
        LOGGER.info("HelloService created");
    }

    public String getMessage() {
        LOGGER.info("getMessage()");
        return "Hello";
    }

    public String getMessageRx() {
        return Single.fromCallable(this::getMessage)
                .subscribeOn(Schedulers.from(executorService))
                .blockingGet();
    }
}
