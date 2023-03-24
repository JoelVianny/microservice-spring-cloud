package com.example.eurekacharacteristic.repository;

import com.example.eurekacharacteristic.entities.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicsRepository extends JpaRepository<Characteristic,Long> {

}
