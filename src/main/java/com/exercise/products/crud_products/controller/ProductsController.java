package com.exercise.products.crud_products.controller;

import com.exercise.products.crud_products.dto.req.ProductsDTOReq;
import com.exercise.products.crud_products.dto.req.ProductsPatchDTOReq;
import com.exercise.products.crud_products.dto.res.ProductsDTORes;
import com.exercise.products.crud_products.model.ProductsModel;
import com.exercise.products.crud_products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<ProductsDTORes>> findAllProducts(){
        List<ProductsDTORes> list = this.productsService.findAllProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsDTORes> findById(@PathVariable("id") Long id){
        ProductsDTORes productsModel = this.productsService.findById(id);
        return ResponseEntity.ok(productsModel);
    }

    @PostMapping
    public ResponseEntity<ProductsDTORes> create(@RequestBody ProductsDTOReq productsDTOReq, UriComponentsBuilder uriBuilder){
        ProductsDTORes newProducts = this.productsService.create(productsDTOReq);
        URI uri = uriBuilder.path("/products/{id}").buildAndExpand(newProducts.id()).toUri();

        return ResponseEntity.created(uri).body(newProducts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsDTORes> update(@PathVariable("id") Long id, @RequestBody ProductsDTOReq productsDTOReq){
        ProductsDTORes productsModel1 = this.productsService.update(id, productsDTOReq);
        return  ResponseEntity.ok(productsModel1);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductsDTORes> updateNameOrPrice(@PathVariable("id") Long id, @RequestBody ProductsPatchDTOReq productsPatchDTOReq) {
        ProductsDTORes productsModel = this.productsService.updateNameOrPrice(id, productsPatchDTOReq);
        return ResponseEntity.ok(productsModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleted(@PathVariable("id") Long id){
        this.productsService.deleted(id);
        return  ResponseEntity.noContent().build();
    }
}
