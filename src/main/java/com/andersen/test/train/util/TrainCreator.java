package com.andersen.test.train.util;

import com.andersen.test.train.exception.TrainUnitNotAvailableException;
import com.andersen.test.train.model.Carriage;
import com.andersen.test.train.model.Locomotive;
import com.andersen.test.train.model.Train;
import com.andersen.test.train.model.TrainUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrainCreator {

  public Train create(List<Locomotive> locomotiveList, List<Carriage> carriageList) {
    List<TrainUnit> units = new ArrayList<>();
    units.addAll(locomotiveList);
    units.addAll(carriageList);
    validateTrainUnits(units);

    Train train = new Train();
    train.setLocomotiveList(locomotiveList);
    train.setCarriageList(carriageList);
    setTrain(units, train);
    return train;
  }

  private void setTrain(List<TrainUnit> units, Train train) {
    units.forEach(u -> u.setTrain(train));
  }

  private void validateTrainUnits(List<? extends TrainUnit> trainUnits) {
    for (TrainUnit unit : trainUnits) {
      boolean isAvailable = checkIfTrainUnitAvailable(unit);
      if (!isAvailable) {
        throw new TrainUnitNotAvailableException(String.format("Unit with uid: %s can not be added into train", unit.getUid()));
      }

    }
  }

  private boolean checkIfTrainUnitAvailable(TrainUnit trainUnit) {
    return Objects.isNull(trainUnit.getTrain());
  }
}
