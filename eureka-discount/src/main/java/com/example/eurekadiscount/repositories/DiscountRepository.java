package com.example.eurekadiscount.repositories;

import com.example.eurekadiscount.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository  extends JpaRepository<Discount,Long> {
}
