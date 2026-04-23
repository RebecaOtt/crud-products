package com.exercise.products.crud_products.service;

import com.exercise.products.crud_products.dto.req.ProductsDTOReq;
import com.exercise.products.crud_products.dto.req.ProductsPatchDTOReq;
import com.exercise.products.crud_products.dto.res.ProductsDTORes;
import com.exercise.products.crud_products.model.ProductsModel;
import com.exercise.products.crud_products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<ProductsDTORes> findAllProducts(LocalDateTime start, LocalDateTime end){
        List<ProductsModel> list;
        if (start != null) {
            list = this.productsRepository.findByCreatedAtBetween(start, end);
        } else {
            list = this.productsRepository.findAll();
        }
        list.forEach(System.out::println);
        return list.stream().map(ProductsDTORes::ModelToDTO).toList();
    }

    public ProductsDTORes findById(Long id) {
        ProductsModel productsModel = this.findByIdEntity(id);
        System.out.println(productsModel);
        return ProductsDTORes.ModelToDTO(productsModel);
    }

    public ProductsDTORes create(ProductsDTOReq productsDTOReq) {
        ProductsModel productsModelRes = this.productsRepository.save(productsDTOReq.dtoToModel());
        return ProductsDTORes.ModelToDTO(productsModelRes);
    }

    public ProductsDTORes update(Long id, ProductsDTOReq productsDTOReq) {
        ProductsModel productsModelRes = this.productsRepository.save(productsDTOReq.dtoToModel(id));
        return ProductsDTORes.ModelToDTO(productsModelRes);
    }

    public ProductsDTORes updateNameOrPrice(Long id, ProductsPatchDTOReq productsPatchDTOReq) {
        ProductsModel productsModel = this.findByIdEntity(id);

        if (productsPatchDTOReq.name() != null){
            productsModel.setName(productsPatchDTOReq.name());
        }
        if (productsPatchDTOReq.price() != null){
            productsModel.setPrice(productsPatchDTOReq.price());
        }

        ProductsModel updateProduct = this.productsRepository.save(productsModel);
        return ProductsDTORes.ModelToDTO(updateProduct);
    }

    public void deleted(Long id) {
        ProductsModel productsModel = this.findByIdEntity(id);
        this.productsRepository.delete(productsModel);
    }

    private ProductsModel findByIdEntity(Long id){
        try {
            return this.productsRepository.findById(id).orElseThrow(()->
                    new ClassNotFoundException("Product not found!"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
