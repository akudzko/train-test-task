package com.andersen.test.train.util;

import com.andersen.test.train.model.Carriage;
import com.andersen.test.train.model.CarriageType;
import java.time.LocalDate;
import java.util.UUID;

public class CarriageCreator {

  public Carriage create(CarriageType type, String producer, Double emptyWeight, Integer length,
      Integer maxPassengerAmount, Double maxValuableWeight, LocalDate productionDate) {
    return Carriage.builder()
        .uid(UUID.randomUUID().toString())
        .type(type)
        .producer(producer)
        .emptyWeight(emptyWeight)
        .length(length)
        .maxPassengerAmount(maxPassengerAmount)
        .maxValuableWeight(maxValuableWeight)
        .productionDate(productionDate)
        .build();
  }

}
