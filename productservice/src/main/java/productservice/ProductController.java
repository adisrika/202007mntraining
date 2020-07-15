package productservice;

import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Controller("/product")
public class ProductController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Inject
    @Named("two")
    CustomThreadpoolConfig customThreadpoolConfig;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @Get("/")
//    @ExecuteOn(TaskExecutors.IO)
//    public Flowable<Product> all() {
//        return productDataService.list();
//    }

    @Get("/{productId}")
    public Product get(@PathVariable("productId") Long id) {
        //LOGGER.info("Custom header " + customHeader);
        if (id != 2L) {
            sleep();
        }
        return productService.getProduct(id);
    }

    private void sleep() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Version("v1")
    @Get("/hello")
    public String helloV1() {
        return "Hello";
    }

    @Version("v2")
    @Get("/hello")
    public String helloV2() {
        return "Hello V2";
    }

    @Get("configprop")
    public CustomThreadpoolConfig configProp() {
        LOGGER.info("keys {} ", customThreadpoolConfig.getData().keySet().contains("number-of-threads"));
        return customThreadpoolConfig;
    }


}