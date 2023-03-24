package com.example.eurekaclientproduct.controller;

import com.example.eurekaclientproduct.entities.Product;
import com.example.eurekaclientproduct.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return  productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return  productService.getAllProduct();
    }

}
