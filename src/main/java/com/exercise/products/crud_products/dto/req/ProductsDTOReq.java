package com.exercise.products.crud_products.dto.req;

import com.exercise.products.crud_products.model.ProductsModel;

import java.math.BigDecimal;

public record ProductsDTOReq(String name, BigDecimal price) {
    public ProductsModel dtoToModel(){
        return new ProductsModel(this.name(), this.price);
    }

    public ProductsModel dtoToModel(Long id){
        return new ProductsModel(id, this.name(), this.price);
    }
}
