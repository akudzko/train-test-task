package com.andersen.test.train.service.impl;

import static com.andersen.test.train.model.CarriageType.PASSENGER;
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

class TrainServiceImplTest {

  private final TrainServiceImpl service = new TrainServiceImpl();

  @Test
  void isTrainMovable() {
    Train train = initTrain();

    boolean isMovable = service.isTrainMovable(train);

    assertTrue(isMovable);
  }

  private Train initTrain() {
    LocomotiveCreator locomotiveCreator = new LocomotiveCreator();
    CarriageCreator carriageCreator = new CarriageCreator();
    TrainCreator trainCreator = new TrainCreator();

    Locomotive firstLocomotive = locomotiveCreator.create("producer", 1000.0, 100.0, 10, 103, 300.0, LocalDate.now());
    Locomotive secondLocomotive = locomotiveCreator.create("producer", 1500.0, 150.0, 10, 101, 400.0, LocalDate.now());
    Carriage carriage = carriageCreator.create(PASSENGER, "producer", 110.0, 10, 200, 300.0, LocalDate.now());
    carriage.setPassengerAmount(153);
    return trainCreator.create(List.of(firstLocomotive, secondLocomotive), List.of(carriage));

  }

}