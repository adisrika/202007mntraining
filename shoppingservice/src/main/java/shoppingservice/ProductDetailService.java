package shoppingservice;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.micronaut.retry.annotation.Retryable;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.NewSpan;
import io.micronaut.tracing.annotation.SpanTag;
import io.reactivex.Flowable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class ProductDetailService {


    @Inject
    private ProductOperations productClient;

    @Retryable(attempts = "2")
    //@CircuitBreaker(attempts = "1", reset = "30s")
    @NewSpan("prod.service")
    public ProductDetail getProductDetail(@SpanTag("product.id") Long id) {
        //HashMap<String, String> headers = new HashMap<>();
        //headers.put("CUSTOM_H", "some value");
        return productClient.getProduct(id, "Custom_header_hello");
    }

    @ContinueSpan
    public void doSomething(@SpanTag("product.id.2") Long id) {

    }


    public Flowable<ProductDetail> getAll() {
        Flowable<ProductDetail> productDetailFlowable = productClient.allProducts();
        //System.out.println(productDetailFlowable.blockingFirst());
        return productDetailFlowable;
    }
}