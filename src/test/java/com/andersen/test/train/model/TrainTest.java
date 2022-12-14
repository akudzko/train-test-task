package com.andersen.test.train.model;

import static com.andersen.test.train.model.CarriageType.PASSENGER;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.andersen.test.train.util.CarriageCreator;
import com.andersen.test.train.util.LocomotiveCreator;
import com.andersen.test.train.util.TrainCreator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class TrainTest {

  @Test
  void getEmptyWeight() {
    Train train = initTrain();

    BigDecimal emptyWeight = train.getEmptyWeight();

    assertEquals(valueOf(360.0), emptyWeight);
  }

  @Test
  void getMaxValuableWeight() {
    Train train = initTrain();

    BigDecimal maxValuableWeight = train.getMaxValuableWeight();

    assertEquals(valueOf(1000.0), maxValuableWeight);
  }

  @Test
  void getMaxPassengersAmount() {
    Train train = initTrain();

    Integer maxPassengersAmount = train.getMaxPassengersAmount();

    assertEquals(404, maxPassengersAmount);
  }

  @Test
  void getCommonMaxValuableWeight() {
    Train train = initTrain();

    BigDecimal commonMaxValuableWeight = train.getCommonMaxValuableWeight();

    assertEquals(valueOf(1000.0 + 404 * 75), commonMaxValuableWeight);
  }

  @Test
  void getMaxCommonWeight() {
    Train train = initTrain();

    BigDecimal maxCommonWeight = train.getMaxCommonWeight();

    assertEquals(valueOf(1000.0 + 404 * 75 + 360), maxCommonWeight);
  }

  @Test
  void getLength() {
    Train train = initTrain();

    Integer length = train.getLength();

    assertEquals(30, length);
  }

  @Test
  void getPassengerAmount() {
    Train train = initTrain();

    Integer passengerAmount = train.getPassengerAmount();

    assertEquals(0, passengerAmount);
  }

  @Test
  void getPullingForce() {
    Train train = initTrain();

    BigDecimal pullingForce = train.getPullingForce();

    assertEquals(valueOf(1000.0 + 1500.0), pullingForce);
  }

  private Train initTrain() {
    LocomotiveCreator locomotiveCreator = new LocomotiveCreator();
    CarriageCreator carriageCreator = new CarriageCreator();
    TrainCreator trainCreator = new TrainCreator();

    Locomotive firstLocomotive = locomotiveCreator.create("producer", valueOf(1000.0), valueOf(100.0), 10, 103, valueOf(300.0), LocalDate.now());
    Locomotive secondLocomotive = locomotiveCreator.create("producer", valueOf(1500.0),valueOf(150.0),  10, 101, valueOf(400.0), LocalDate.now());
    Carriage carriage = carriageCreator.create(PASSENGER, "producer", valueOf(110.0), 10, 200, valueOf(300.0), LocalDate.now());
    Train train = trainCreator.create(List.of(firstLocomotive, carriage, secondLocomotive));

    return train;
  }
}