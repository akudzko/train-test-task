package com.andersen.test.train.service.impl;

import com.andersen.test.train.model.TrainUnit;
import com.andersen.test.train.service.TrainUnitService;
import java.math.BigDecimal;

public class TrainUnitServiceImpl implements TrainUnitService {

  @Override
  public boolean addPassenger(TrainUnit trainUnit, Integer passengersAmount) {
    Integer availablePassengersAmount = trainUnit.getMaxPassengerAmount() - trainUnit.getPassengerAmount();
    if (passengersAmount >= 0 && availablePassengersAmount >= passengersAmount) {
      trainUnit.setPassengerAmount(trainUnit.getPassengerAmount() + passengersAmount);
      return true;
    }
    return false;
  }

  @Override
  public boolean addCargo(TrainUnit trainUnit, BigDecimal cargo) {
    BigDecimal availableCargo = trainUnit.getMaxValuableWeight().subtract(trainUnit.getValuableWeight());
    if (cargo.compareTo(BigDecimal.ZERO) >= 0 && availableCargo.compareTo(cargo) >= 0) {
      trainUnit.setValuableWeight(trainUnit.getValuableWeight().add(cargo));
      return true;
    }
    return false;
  }
}
