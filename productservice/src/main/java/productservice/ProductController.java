package productservice;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/product")
public class ProductController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Get("/")
    @ExecuteOn(TaskExecutors.IO)
    public Flowable<Product> all() {
        return productService.list();
    }

    @Get("/{productId}")
    public Product get(@PathVariable("productId") Long id, @Header("ch") String customHeader) {
        LOGGER.info("Custom header " + customHeader);
        if (id != 2L) {
            sleep();
        }
        return productService.get(id);
    }

    private void sleep() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}