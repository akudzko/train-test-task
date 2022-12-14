package com.andersen.test.train.model;

import static com.andersen.test.train.model.CarriageType.PASSENGER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.andersen.test.train.util.CarriageCreator;
import com.andersen.test.train.util.LocomotiveCreator;
import com.andersen.test.train.util.TrainCreator;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class TrainTest {

  @Test
  void getEmptyWeight() {
    Train train = initTrain();

    Double emptyWeight = train.getEmptyWeight();

    assertEquals(360.0, emptyWeight);
  }

  @Test
  void getMaxValuableWeight() {
    Train train = initTrain();

    Double maxValuableWeight = train.getMaxValuableWeight();

    assertEquals(1000.0, maxValuableWeight);
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

    Double commonMaxValuableWeight = train.getCommonMaxValuableWeight();

    assertEquals(1000.0 + 404 * 75, commonMaxValuableWeight);
  }

  @Test
  void getMaxCommonWeight() {
    Train train = initTrain();

    Double maxCommonWeight = train.getMaxCommonWeight();

    assertEquals(1000.0 + 404 * 75 + 360, maxCommonWeight);
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

    Double pullingForce = train.getPullingForce();

    assertEquals(1000.0 + 1500.0, pullingForce);
  }

  private Train initTrain() {
    LocomotiveCreator locomotiveCreator = new LocomotiveCreator();
    CarriageCreator carriageCreator = new CarriageCreator();
    TrainCreator trainCreator = new TrainCreator();

    Locomotive firstLocomotive = locomotiveCreator.create("producer", 1000.0, 100.0, 10, 103, 300.0, LocalDate.now());
    Locomotive secondLocomotive = locomotiveCreator.create("producer", 1500.0,150.0,  10, 101, 400.0, LocalDate.now());
    Carriage carriage = carriageCreator.create(PASSENGER, "producer", 110.0, 10, 200, 300.0, LocalDate.now());
    Train train = trainCreator.create(List.of(firstLocomotive, secondLocomotive), List.of(carriage));

    return train;
  }
}