package shoppingservice;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.HttpClientConfiguration;
import io.micronaut.http.client.RxHttpClient;
import io.reactivex.Flowable;

import javax.inject.Inject;

@Controller("/shopping")
public class ProductDetailController {

    @Inject
    HttpClientConfiguration httpClientConfiguration;

    @Inject
    MyProcessor processor;

    private ProductDetailService productDetailService;

    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @Get("/{productId}")
    public ProductDetail get(@PathVariable("productId") Long id) {
        ProductDetail productDetail = productDetailService.getProductDetail(id);
        productDetailService.doSomething(id);
        return productDetail;
        //return new ProductDetail();
    }

    @Get("/product")
    Flowable<ProductDetail> all() {
        return productDetailService.getAll();
    }

    @Get("/httpconf")
    public String info() {
        httpClientConfiguration.getConnectionPoolConfiguration().setEnabled(true);
        System.out.println(httpClientConfiguration.getConnectionPoolConfiguration().isEnabled());
        System.out.println(httpClientConfiguration.getConnectionPoolConfiguration().getMaxConnections());
        return "done";
    }

    @Get("/retry")
    public String retry() {
        processor.process();
        return "done";
    }
}