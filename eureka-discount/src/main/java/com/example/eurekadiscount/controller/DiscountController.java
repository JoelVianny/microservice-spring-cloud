package com.example.eurekadiscount.controller;

import com.example.eurekadiscount.entities.Discount;
import com.example.eurekadiscount.service.DiscountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("public/discount")
public class DiscountController {
    private DiscountService discountService;

    @GetMapping("/{id}")
    public Discount getDiscount(@PathVariable long id){
        return  discountService.getDiscount(id);
    }
    @PostMapping
    public Discount createDiscount(@Valid @RequestBody Discount discount){
        return discountService.saveDiscount(discount);
    }

    @PutMapping("/{id}")
    public Discount updateDiscount(@PathVariable long id, @RequestBody Discount discount){
        return  discountService.updateDiscount(id,discount);
    }

    @DeleteMapping
    public  String deleteCharacteristic(@PathVariable long id){
        return  discountService.deleteDiscount(id);
    }
}
