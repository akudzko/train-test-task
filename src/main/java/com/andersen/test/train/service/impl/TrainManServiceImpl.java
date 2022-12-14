package com.andersen.test.train.service.impl;

import com.andersen.test.train.model.TrainAble;
import com.andersen.test.train.service.TrainManService;

public class TrainManServiceImpl implements TrainManService {

  public static final Integer PASSENGERS_AMOUNT_ON_ONE_TRAIN_MAN = 50;

  @Override
  public boolean isTrainManNeeded(TrainAble train) {
    return train.getPassengerAmount() > 0;
  }

  @Override
  public Integer getNeededTrainManAmount(TrainAble train) {

    Integer passengerAmount = train.getPassengerAmount();
    if (passengerAmount > 0) {
      return passengerAmount / PASSENGERS_AMOUNT_ON_ONE_TRAIN_MAN + 1;
    }

    return 0;
  }


}
