package mndatajdbc;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;

@Singleton
public class AppInitiazer {

    private static Logger LOGGER = LoggerFactory.getLogger(AppInitiazer.class);

    private ProductRepository repository;

    @Inject
    private ProductReposotory2 productReposotory2;

    @Inject
    private PgProductRepository pgProductRepository;


    public AppInitiazer(ProductRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void init(StartupEvent event) {
        repository.save(new Product("PRD1", "Effective Java", BigDecimal.valueOf(599)));
        LOGGER.info("received {} ", repository.findById(1L));
        LOGGER.info("received {} ", repository.find("PRD1"));
        LOGGER.info("received {} ", repository.find("PRD1", "Effective Java"));

        //productReposotory2.fi
        //pgProductRepository.findAll()

    }
}
