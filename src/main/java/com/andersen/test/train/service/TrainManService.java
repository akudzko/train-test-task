package com.andersen.test.train.service;

import com.andersen.test.train.model.TrainAble;

public interface TrainManService {

  boolean isTrainManNeeded(TrainAble train);

  Integer getNeededTrainManAmount(TrainAble train);
}
