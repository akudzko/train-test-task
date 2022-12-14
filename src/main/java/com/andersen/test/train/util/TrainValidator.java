package com.andersen.test.train.util;

import com.andersen.test.train.exception.TrainInvalidStateException;
import com.andersen.test.train.exception.TrainUnitNotAvailableException;
import com.andersen.test.train.model.Locomotive;
import com.andersen.test.train.model.TrainUnit;
import java.util.List;
import java.util.Objects;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TrainValidator {
  public static void trainMustContainLocomotives(List<TrainUnit> units) {
    boolean anyMatch = units.stream()
        .anyMatch(Locomotive.class::isInstance);
    if (!anyMatch){
      throw new TrainInvalidStateException("Train has no locomotive");
    }
  }

  public static void unitMustNotBelongAnotherTrain(List<? extends TrainUnit> trainUnits) {
    for (TrainUnit unit : trainUnits) {
      boolean isAvailable = checkIfTrainUnitAvailable(unit);
      if (!isAvailable) {
        throw new TrainUnitNotAvailableException(String.format("Unit with uid: %s can not be added into train", unit.getUid()));
      }
    }
  }

  private static boolean checkIfTrainUnitAvailable(TrainUnit trainUnit) {
    return Objects.isNull(trainUnit.getTrain());
  }

}
