package com.exercise.products.crud_products.repository;

import com.exercise.products.crud_products.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel, Long> {
}
