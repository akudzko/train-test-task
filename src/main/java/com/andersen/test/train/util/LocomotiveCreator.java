package com.andersen.test.train.util;

import com.andersen.test.train.model.Locomotive;
import java.time.LocalDate;
import java.util.UUID;

public class LocomotiveCreator {

  public Locomotive create(String producer, Double pullingForce, Double emptyWeight, Integer length, Integer maxPassengerAmount,
      Double maxValuableWeight, LocalDate productionDate) {
    return (Locomotive) Locomotive.builder()
        .uid(UUID.randomUUID().toString())
        .producer(producer)
        .pullingForce(pullingForce)
        .emptyWeight(emptyWeight)
        .length(length)
        .maxPassengerAmount(maxPassengerAmount)
        .maxValuableWeight(maxValuableWeight)
        .productionDate(productionDate)
        .build();
  }
}
