package shoppingservice;

import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Flowable;

import java.util.Map;

@Fallback
public class FallbackProductClient implements ProductOperations {
    @Override
    public ProductDetail getProduct(Long productId, String values) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId(10L);
        return productDetail;
    }

    @Override
    public Flowable<ProductDetail> allProducts() {
        return null;
    }
}
