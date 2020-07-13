package shoppingservice;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import io.reactivex.Flowable;

import java.util.Map;

public interface ProductOperations {
    @Get("/product/{productId}")
    ProductDetail getProduct(@PathVariable Long productId, @Header(defaultValue = "CH") String ch);

    @Get(uri = "/product")
    Flowable<ProductDetail> allProducts();
}
