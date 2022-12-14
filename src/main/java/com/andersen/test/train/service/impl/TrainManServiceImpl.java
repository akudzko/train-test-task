package com.andersen.test.train.service.impl;

import com.andersen.test.train.model.TrainQuality;
import com.andersen.test.train.service.TrainManService;

public class TrainManServiceImpl implements TrainManService {

  public static final Integer PASSENGERS_AMOUNT_ON_ONE_TRAIN_MAN = 50;

  @Override
  public boolean isTrainManNeeded(TrainQuality train) {
    return train.getPassengerAmount() > 0;
  }

  @Override
  public Integer getNeededTrainManAmount(TrainQuality train) {

    Integer passengerAmount = train.getPassengerAmount();
    if (passengerAmount > 0) {
      return passengerAmount / PASSENGERS_AMOUNT_ON_ONE_TRAIN_MAN + 1;
    }

    return 0;
  }


}
