package com.example.eurekaclientproduct.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private double price;
    @NonNull
    private long organizationId;
    @NonNull
    private double ratings;
    private String reviews;
    private long discountId;
    @NonNull
    private long characteristicId;


}
