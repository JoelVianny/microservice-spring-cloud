package com.example.eurekacharacteristic.controller;


import com.example.eurekacharacteristic.entities.Characteristic;
import com.example.eurekacharacteristic.service.CharacteristicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/public/characteristics")
public class CharacteristicsController {

    private final CharacteristicsService characteristicsService;

    @GetMapping("/{id}")
    public Characteristic getCharacteristics(@PathVariable long id){
         return characteristicsService.getCharacteristics(id);
    }

    @PutMapping("/{id}")
    public Characteristic editCharacteristics(@PathVariable long id, @RequestBody Characteristic characteristics){
        return  characteristicsService.updateCharacteristics(id,characteristics);
    }

    @PostMapping
    public Characteristic createCharacteristics(@RequestBody Characteristic characteristics){
        return  characteristicsService.saveCharacteristics(characteristics);
    }

    @DeleteMapping("/{id}")
    public  String removeCharacteristics(@PathVariable long id){
        return  characteristicsService.deleteCharacteristic(id);
    }
}
