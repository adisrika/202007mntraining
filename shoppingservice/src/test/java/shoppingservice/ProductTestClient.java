package shoppingservice;

import io.micronaut.context.annotation.Replaces;
import io.reactivex.Flowable;

@Replaces(ProductClient.class)
public class ProductTestClient implements ProductClient{
    @Override
    public ProductDetail getProduct(Long productId, String ch) {
        return null;
    }

    @Override
    public Flowable<ProductDetail> allProducts() {
        return null;
    }
}
