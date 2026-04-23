package com.exercise.products.crud_products.repository;

import com.exercise.products.crud_products.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel, Long> {
    List<ProductsModel> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}
