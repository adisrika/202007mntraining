package mndatajdbc;


import io.micronaut.data.annotation.MappedEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

//@MappedEntity
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String sku;
    private String description;
    private BigDecimal mrp;

    public Product(String sku, String description, BigDecimal mrp) {
        this.sku = sku;
        this.description = description;
        this.mrp = mrp;
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

    public BigDecimal getMrp() {
        return mrp;
    }

    public void setMrp(BigDecimal mrp) {
        this.mrp = mrp;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", mrp=" + mrp +
                '}';
    }
}
