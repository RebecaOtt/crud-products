package com.exercise.products.crud_products.service;

import com.exercise.products.crud_products.dto.req.ProductsDTOReq;
import com.exercise.products.crud_products.dto.req.ProductsPatchDTOReq;
import com.exercise.products.crud_products.dto.res.ProductsDTORes;
import com.exercise.products.crud_products.model.ProductsModel;
import com.exercise.products.crud_products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<ProductsDTORes> findAllProducts(){
        List<ProductsModel> list = this.productsRepository.findAllProducts();
        list.forEach(System.out::println);
        return list.stream().map(ProductsDTORes::ModelToDTO).toList();
    }

    public ProductsDTORes findById(Long id) {
        ProductsModel productsModel = this.productsRepository.findById(id);
        System.out.println(productsModel);
        return ProductsDTORes.ModelToDTO(productsModel);
    }

    public ProductsDTORes create(ProductsDTOReq productsDTOReq) {
        ProductsModel productsModelRes = this.productsRepository.create(productsDTOReq.dtoToModel());
        return ProductsDTORes.ModelToDTO(productsModelRes);
    }

    public ProductsDTORes update(Long id, ProductsDTOReq productsDTOReq) {
        ProductsModel productsModelRes = this.productsRepository.update(productsDTOReq.dtoToModel(id));
        return ProductsDTORes.ModelToDTO(productsModelRes);
    }

    public ProductsDTORes updateNameOrPrice(Long id, ProductsPatchDTOReq productsPatchDTOReq) {
        ProductsModel productsModelRes = null;

        if (productsPatchDTOReq.name() != null) {
            productsModelRes = this.productsRepository.updateName(id, productsPatchDTOReq.name());
        }
        if (productsPatchDTOReq.price() != null) {
            productsModelRes = this.productsRepository.updatePrice(id, productsPatchDTOReq.price());
        }
        return ProductsDTORes.ModelToDTO(productsModelRes);
    }

    public void deleted(Long id) {
        this.productsRepository.deleted(id);
    }
}
