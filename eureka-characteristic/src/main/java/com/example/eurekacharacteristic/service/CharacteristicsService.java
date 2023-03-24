package com.example.eurekacharacteristic.service;


import com.example.eurekacharacteristic.entities.Characteristic;
import com.example.eurekacharacteristic.repository.CharacteristicsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class CharacteristicsService {

    private CharacteristicsRepository  characteristicsRepository;

    public Characteristic getCharacteristics(long id){
        return  characteristicsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found"));
    }

    public  Characteristic saveCharacteristics(Characteristic characteristics){
        log.info(characteristics.toString());
        Characteristic createCharacteristic = characteristicsRepository.save(characteristics);
        log.info(createCharacteristic.toString());
        return  createCharacteristic;
    }

    public Characteristic updateCharacteristics(long id,Characteristic characteristics){

        log.info(characteristics.toString());
        Characteristic foundCharacteristics= getCharacteristics(id);
        foundCharacteristics.setName(characteristics.getName());
        foundCharacteristics.setValue(characteristics.getValue());
                    log.info(foundCharacteristics.toString());
              return  characteristicsRepository.save(foundCharacteristics);
    }

    public  String deleteCharacteristic(long id){
        characteristicsRepository.delete(getCharacteristics(id));
        return  "Characteristic  deleted";
    }

}
