package productservice;

import io.micronaut.tracing.annotation.NewSpan;
import io.reactivex.Flowable;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class ProductService {

    private static Map<Long, Product> products = new HashMap<>();

    @PostConstruct
    public void init() {
        Arrays.asList(
                new Product(1L, "PRD1", "Effective Java"),
                new Product(2L, "PRD2", "Programming Groovy 2"),
                new Product(3L, "PRD3", "Groovy Recipies"),
                new Product(4L, "PRD4", "Groovy in Action")
        ).forEach(product -> products.put(product.getId(), product));
    }

    public Flowable<Product> list() {
        return Flowable.fromIterable(products.values());
    }

    @NewSpan("prod.service")
    public Product get(Long id) {
        return products.get(id);
    }

}