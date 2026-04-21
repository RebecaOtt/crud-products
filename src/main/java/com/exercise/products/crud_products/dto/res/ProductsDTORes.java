package com.exercise.products.crud_products.dto.res;

import com.exercise.products.crud_products.model.ProductsModel;

import java.math.BigDecimal;

public record ProductsDTORes(Long id, String name, BigDecimal price) {
    public static ProductsDTORes ModelToDTO(ProductsModel productsModel) {
        return new ProductsDTORes(productsModel.getId(), productsModel.getName(), productsModel.getPrice());
    }
}
