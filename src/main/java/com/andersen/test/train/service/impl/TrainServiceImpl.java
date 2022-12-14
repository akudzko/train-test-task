package com.andersen.test.train.service.impl;

import com.andersen.test.train.model.Train;
import com.andersen.test.train.service.TrainService;

public class TrainServiceImpl implements TrainService {

  @Override
  public boolean isTrainMovable(Train train) {
    int comparingResult = train.getPullingForce().compareTo(train.getMaxValuableWeight());
    return comparingResult > 0;
  }

}
