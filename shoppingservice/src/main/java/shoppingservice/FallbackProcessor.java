package shoppingservice;

import io.micronaut.retry.annotation.Fallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Fallback
public class FallbackProcessor implements MyProcessor {

    private static Logger LOGGER = LoggerFactory.getLogger(FallbackProcessor.class);

    @Override
    public void process() {
        LOGGER.info("Fallback called");
    }
}
