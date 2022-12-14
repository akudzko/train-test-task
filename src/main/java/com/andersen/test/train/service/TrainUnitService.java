package com.andersen.test.train.service;

import com.andersen.test.train.model.TrainUnit;
import java.math.BigDecimal;

public interface TrainUnitService {

  boolean addPassenger(TrainUnit trainUnit, Integer passengersAmount);

  boolean addCargo(TrainUnit trainUnit, BigDecimal cargo);
}
