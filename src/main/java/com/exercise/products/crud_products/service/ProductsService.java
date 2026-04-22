package com.exercise.products.crud_products.service;

import com.exercise.products.crud_products.dto.req.ProductsDTOReq;
import com.exercise.products.crud_products.dto.req.ProductsPatchDTOReq;
import com.exercise.products.crud_products.dto.res.ProductsDTORes;
import com.exercise.products.crud_products.model.ProductsModel;
import com.exercise.products.crud_products.repository.ProductsRepository;
import com.exercise.products.crud_products.repository.ProductsRepositoryLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepositoryLocal productsRepositoryLocal;

    @Autowired
    private ProductsRepository productsRepository;

    public List<ProductsDTORes> findAllProducts(){
        List<ProductsModel> list = this.productsRepositoryLocal.findAllProducts();
        list.forEach(System.out::println);
        return list.stream().map(ProductsDTORes::ModelToDTO).toList();
    }

    public ProductsDTORes findById(Long id) {
        ProductsModel productsModel = this.productsRepositoryLocal.findById(id);
        System.out.println(productsModel);
        return ProductsDTORes.ModelToDTO(productsModel);
    }

    public ProductsDTORes create(ProductsDTOReq productsDTOReq) {
//        ProductsModel productsModelRes = this.productsRepositoryLocal.create(productsDTOReq.dtoToModel());
        ProductsModel productsModelRes = this.productsRepository.save(productsDTOReq.dtoToModel());
        return ProductsDTORes.ModelToDTO(productsModelRes);
    }

    public ProductsDTORes update(Long id, ProductsDTOReq productsDTOReq) {
        ProductsModel productsModelRes = this.productsRepositoryLocal.update(productsDTOReq.dtoToModel(id));
        return ProductsDTORes.ModelToDTO(productsModelRes);
    }

    public ProductsDTORes updateNameOrPrice(Long id, ProductsPatchDTOReq productsPatchDTOReq) {
        ProductsModel productsModelRes = null;

        if (productsPatchDTOReq.name() != null) {
            productsModelRes = this.productsRepositoryLocal.updateName(id, productsPatchDTOReq.name());
        }
        if (productsPatchDTOReq.price() != null) {
            productsModelRes = this.productsRepositoryLocal.updatePrice(id, productsPatchDTOReq.price());
        }
        return ProductsDTORes.ModelToDTO(productsModelRes);
    }

    public void deleted(Long id) {
        this.productsRepositoryLocal.deleted(id);
    }
}
