package mnstandalone;

import io.micronaut.context.annotation.Primary;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("one")
public class DCalculator1 implements DiscountCalculator {
    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void cleanup() {
    }

}
