package com.andersen.test.train.service.impl;

import static com.andersen.test.train.model.CarriageType.PASSENGER;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.andersen.test.train.model.Carriage;
import com.andersen.test.train.model.Locomotive;
import com.andersen.test.train.model.Train;
import com.andersen.test.train.util.CarriageCreator;
import com.andersen.test.train.util.LocomotiveCreator;
import com.andersen.test.train.util.TrainCreator;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class TrainManServiceImplTest {

  private final TrainManServiceImpl service = new TrainManServiceImpl();

  @Test
  void isTrainManNeeded() {
    Train train = initTrain();

    boolean trainManNeeded = service.isTrainManNeeded(train);
    assertTrue(trainManNeeded);
  }

  @Test
  void getNeededTrainManAmount() {
    Train train = initTrain();

    Integer neededTrainManAmount = service.getNeededTrainManAmount(train);

    assertEquals(4, neededTrainManAmount);
  }

  private Train initTrain() {
    LocomotiveCreator locomotiveCreator = new LocomotiveCreator();
    CarriageCreator carriageCreator = new CarriageCreator();
    TrainCreator trainCreator = new TrainCreator();

    Locomotive firstLocomotive = locomotiveCreator.create("producer", valueOf(1000.0), valueOf(100.0), 10, 103, valueOf(300.0), LocalDate.now());
    Locomotive secondLocomotive = locomotiveCreator.create("producer", valueOf(1500.0), valueOf(150.0), 10, 101, valueOf(400.0), LocalDate.now());
    Carriage carriage = carriageCreator.create(PASSENGER, "producer", valueOf(110.0), 10, 200, valueOf(300.0), LocalDate.now());
    carriage.setPassengerAmount(153);
    Train train = trainCreator.create(List.of(firstLocomotive, carriage, secondLocomotive));

    return train;
  }
}