package mnstandalone;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Product {

    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                '}';
    }
}
