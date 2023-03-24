package com.example.eurekaclientproduct.services;

import com.example.eurekaclientproduct.entities.Product;
import com.example.eurekaclientproduct.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private  final ProductRepository productRepository;


    public List<Product> getAllProduct(){
        return  productRepository.findAll();
    }

    public Product getProduct(long id){
        return  productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found"));
    }




}
