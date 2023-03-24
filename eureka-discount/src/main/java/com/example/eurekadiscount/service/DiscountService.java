package com.example.eurekadiscount.service;

import com.example.eurekadiscount.entities.Discount;
import com.example.eurekadiscount.repositories.DiscountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;

    public Discount getDiscount(long id){
        return  discountRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Not found"));
    }

    public Discount saveDiscount(Discount discount){
        log.info(discount.toString());
        Discount createDiscount = discountRepository.save(discount);
        log.info(createDiscount.toString());
        return  createDiscount;

    }

    public Discount updateDiscount(long id, Discount discount){
        log.info(discount.toString());
        Discount foundDiscount = getDiscount(id);
         foundDiscount.setVolume(discount.getVolume());
         foundDiscount.setDate(discount.getDate());
         log.info(foundDiscount.toString());
         return  discountRepository.save(foundDiscount);

    }

    public String deleteDiscount(long id){
        discountRepository.delete(getDiscount(id));
        return  "Discount removed";
    }
}
