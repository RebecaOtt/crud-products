package com.exercise.products.crud_products.repository;

import com.exercise.products.crud_products.model.ProductsModel;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductsRepository {
    private List<ProductsModel> productsInit = Arrays.asList(
            new ProductsModel(1L, "Arroz", new BigDecimal("20.00")),
            new ProductsModel(2L, "Feijão", new BigDecimal("26.50"))
    );

    private List<ProductsModel> products = new ArrayList<>(productsInit);

    public List<ProductsModel> findAllProducts(){
        return products;
    }

    public ProductsModel findById(Long id) {
        try {
            return products.stream().filter(products ->
                    products.getId().equals(id)).findFirst().orElseThrow(()->
                    new ClassNotFoundException("Product not found!!"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ProductsModel create(ProductsModel productsModel) {
        productsModel.setId(products.size()+1L);
        products.add(productsModel);
        return productsModel;
    }

    public ProductsModel update(ProductsModel productsModel) {
        ProductsModel oldProductsModel = this.findById(productsModel.getId());
        products.remove(oldProductsModel);

        productsModel.setUpdateAt(LocalDateTime.now());

        products.add(productsModel);
        return productsModel;
    }

    public ProductsModel updateName(Long id, String name) {
        ProductsModel productsModel = this.findById(id);
        productsModel.setName(name);

        productsModel.setUpdateAt(LocalDateTime.now());

        return productsModel;
    }

    public ProductsModel updatePrice(Long id, BigDecimal price) {
        ProductsModel productsModel = this.findById(id);
        productsModel.setPrice(price);
        productsModel.setUpdateAt(LocalDateTime.now());
        return productsModel;
    }

    public void deleted(Long id) {
        ProductsModel productsModel = this.findById(id);
        products.remove(productsModel);
    }
}
