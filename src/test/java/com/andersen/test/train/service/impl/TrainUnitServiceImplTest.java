package com.andersen.test.train.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.andersen.test.train.model.TrainUnit;
import com.andersen.test.train.service.TrainUnitService;
import com.andersen.test.train.util.LocomotiveCreator;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TrainUnitServiceImplTest {

  private final LocomotiveCreator locomotiveCreator = new LocomotiveCreator();
  private final TrainUnitService trainUnitService = new TrainUnitServiceImpl();

  @Test
  void addPassenge() {
    TrainUnit unit = locomotiveCreator.create("producer", BigDecimal.valueOf(1000.0), BigDecimal.valueOf(100.0), 10, 103,
        BigDecimal.valueOf(300.0), LocalDate.now());

    boolean result = trainUnitService.addPassenger(unit, 100);

    assertTrue(result);
  }

  @Test
  void addCargo() {
    TrainUnit unit = locomotiveCreator.create("producer", BigDecimal.valueOf(1000.0), BigDecimal.valueOf(100.0), 10, 103,
        BigDecimal.valueOf(300.0), LocalDate.now());

    boolean result = trainUnitService.addCargo(unit, BigDecimal.valueOf(150.0));

    assertTrue(result);
  }

  @ParameterizedTest
  @ValueSource(ints = {-10, 104, Integer.MAX_VALUE})
  void addPassengeNegative(int passengerAmount) {
    TrainUnit unit = locomotiveCreator.create("producer", BigDecimal.valueOf(1000.0), BigDecimal.valueOf(100.0), 10, 103,
        BigDecimal.valueOf(300.0), LocalDate.now());

    boolean result = trainUnitService.addPassenger(unit, passengerAmount);

    assertFalse(result);
  }

  @ParameterizedTest
  @ValueSource(doubles = {-10.0, 350.0, Double.MAX_VALUE})
  void addCargoNegative(double cargo) {
    TrainUnit unit = locomotiveCreator.create("producer", BigDecimal.valueOf(1000.0), BigDecimal.valueOf(100.0), 10, 103,
        BigDecimal.valueOf(300.0), LocalDate.now());

    boolean result = trainUnitService.addCargo(unit, BigDecimal.valueOf(cargo));

    assertFalse(result);
  }
}