package com.exercise.products.crud_products.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductsModel {

    public ProductsModel(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    public ProductsModel(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    private Long id;

    private String name;

    private BigDecimal price;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "ProductsModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
