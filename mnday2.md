#Day 2 

##1. Product Service
Create a project using the following command

~~~
create-app productservice
~~~

Add the following files


**Product.java**

~~~java
package productservice;

public class Product {
    private Long id;
    private String sku;
    private String description;

    public Product(Long id, String sku, String description) {
        this.id = id;
        this.sku = sku;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
~~~

**ProductService.java**

~~~java
package productservice;

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

    public Product get(Long id) {
        return products.get(id);
    }

}
~~~

**ProductController.java**

~~~java
package productservice;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.reactivex.Flowable;

@Controller("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Get("/")
    public Flowable<Product> all() {
        return productService.list();
    }

    @Get("/{productId}")
    public Product get(@PathVariable("productId") Long id) {
        return productService.get(id);
    }

}
~~~

##2. Shopping Service

Create the service by running the following command in Micronaut cli

~~~
create-app shoppingservice
~~~

Add the following classes

**ProductDetail.java**

~~~java
package shoppingservice;

import java.math.BigDecimal;

public class ProductDetail {
    private Long id;
    private String sku;
    private String description;
    private BigDecimal sellingPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
~~~

**ProductDetailService.java**

~~~java
package shoppingservice;

import javax.inject.Singleton;

@Singleton
public class ProductDetailService {

    public ProductDetail getProductDetail(Long id) {
        return null;
    }
}

~~~

**ProductDetailController.java**

~~~java
package shoppingservice;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller("/shopping")
public class ProductDetailController {

    private ProductDetailService productDetailService;

    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @Get("/{productId}")
    public ProductDetail get(@PathVariable("productId") Long id) {
        return productService.get(id);
    }
}

~~~



---

##Service Discovery

Add `discovery-consul` feature to product service

~~~
mn> feature-diff --features discovery-consul
~~~

Save the output to <some-path>/my.patch

Apply the patch

~~~
git apply <some-path>/my.patch
~~~

Start consul application

~~~
docker run -p 8500:8500 consul
~~~

Start product service using gradle

Repeat the steps for shopping service

##Distributed Tracing

Bring up zipkin using the following command

~~~
docker run -p 9411:9411 openzipkin/zipkin
~~~

Add the dependnecies and configurations. To fidn these

~~~
mn> feature-diff --features tracing-zipkin
~~~


