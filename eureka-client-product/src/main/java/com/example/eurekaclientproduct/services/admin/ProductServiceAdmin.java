package com.example.eurekaclientproduct.services.admin;


import com.example.eurekaclientproduct.entities.Product;
import com.example.eurekaclientproduct.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceAdmin {
    private final ProductRepository productRepository;

    private RestTemplate restTemplate;

    public Product getProduct(long id){
        return  productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found"));
    }

    public Product saveProduct( Product product){
        log.info(product.toString());
        Product createProduct = productRepository.save(product);
        log.info(createProduct.toString());
        return createProduct;
    }

    public  Product updateProduct(long id, Product product){
        log.info(product.toString());
        ResponseEntity<Long>  organizationId = restTemplate.exchange("/localhost:1001/eorganization/public/organizations/id", HttpMethod.GET,null , Long.class);
        ResponseEntity<Long>  discountId = restTemplate.exchange("/localhost:1002/ediscount/public/public/discount/id", HttpMethod.GET,null , Long.class);
        Product foundProduct =  getProduct(id);
        foundProduct.setName(product.getName());
        foundProduct.setDescription(product.getDescription());
        foundProduct.setPrice(product.getPrice());
        foundProduct.setRatings(product.getRatings());
        foundProduct.setOrganizationId(organizationId.getBody());
        foundProduct.setDiscountId(discountId.getBody());
        log.info(foundProduct.toString());
        return   productRepository.save(foundProduct);
    }

    public String deleteProduct(long id){
        productRepository.delete(getProduct(id));
        return  "Product deleted";

    }



}
