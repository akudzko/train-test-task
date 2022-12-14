package com.andersen.test.train.util;

import static com.andersen.test.train.util.TrainValidator.trainMustContainLocomotives;
import static com.andersen.test.train.util.TrainValidator.unitMustNotBelongAnotherTrain;

import com.andersen.test.train.model.Train;
import com.andersen.test.train.model.TrainUnit;
import java.util.LinkedList;
import java.util.List;

public class TrainCreator {

  public Train create(List<TrainUnit> unitList) {
    List<TrainUnit> units = new LinkedList<>(unitList);
    unitMustNotBelongAnotherTrain(units);
    trainMustContainLocomotives(units);

    Train train = new Train();
    train.setUnitList(units);
    setTrain(units, train);
    return train;
  }

  private void setTrain(List<TrainUnit> units, Train train) {
    units.forEach(u -> u.setTrain(train));
  }

}
