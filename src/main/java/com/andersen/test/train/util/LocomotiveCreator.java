package com.andersen.test.train.util;

import static java.math.BigDecimal.valueOf;

import com.andersen.test.train.model.Locomotive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class LocomotiveCreator {

  public Locomotive create(String producer, BigDecimal pullingForce, BigDecimal emptyWeight, Integer length, Integer maxPassengerAmount,
      BigDecimal maxValuableWeight, LocalDate productionDate) {
    return (Locomotive) Locomotive.builder()
        .uid(UUID.randomUUID().toString())
        .producer(producer)
        .pullingForce(pullingForce)
        .emptyWeight(emptyWeight)
        .length(length)
        .maxPassengerAmount(maxPassengerAmount)
        .maxValuableWeight(maxValuableWeight)
        .productionDate(productionDate)
        .passengerAmount(0)
        .valuableWeight(valueOf(0))
        .build();
  }
}
