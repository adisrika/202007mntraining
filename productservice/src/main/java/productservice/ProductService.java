package productservice;

import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.CachePut;
import io.micronaut.cache.annotation.Cacheable;

import javax.inject.Singleton;

@Singleton
public class ProductService {

    private ProductDataService productDataService;

    public ProductService(ProductDataService productDataService) {
        this.productDataService = productDataService;
    }

    @Cacheable("product-cache")
    public Product getProduct(Long id) {
        return productDataService.get(id);
    }

    //@CachePut("product-cache")
    //public void save()˜


    //@CacheInvalidate
    //public void delete()

}
