package com.example.eurekaclientproduct.controller.admin;

import com.example.eurekaclientproduct.entities.Product;
import com.example.eurekaclientproduct.services.admin.ProductServiceAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class ProductControllerAdmin {
    private  final ProductServiceAdmin productServiceAdmin;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return  productServiceAdmin.getProduct(id);
    }

    @PostMapping()
    public Product  createProduct(@RequestBody Product product){
        return productServiceAdmin.saveProduct(product);
    }

    @PutMapping("/{id}")
    public  Product updateProduct(@PathVariable long id, @RequestBody Product product){
        return productServiceAdmin.updateProduct(id,product);
    }
    @DeleteMapping("/{id}")
    public  String removeProduct(@PathVariable long id){
        return  productServiceAdmin.deleteProduct(id);
    }



}
