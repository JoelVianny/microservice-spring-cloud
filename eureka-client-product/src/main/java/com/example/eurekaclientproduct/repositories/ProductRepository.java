package com.example.eurekaclientproduct.repositories;


import com.example.eurekaclientproduct.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long > {

}
