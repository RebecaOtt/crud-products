package com.exercise.products.crud_products.dto.res;

import com.exercise.products.crud_products.model.ProductsModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductsDTORes(Long id, String name, BigDecimal price, LocalDateTime createdAt) {
    public static ProductsDTORes ModelToDTO(ProductsModel productsModel) {
        return new ProductsDTORes(productsModel.getId(), productsModel.getName(), productsModel.getPrice(), productsModel.getCreatedAt());
    }
}
