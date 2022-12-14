package com.andersen.test.train.service;

import com.andersen.test.train.model.TrainQuality;

public interface TrainManService {

  boolean isTrainManNeeded(TrainQuality train);

  Integer getNeededTrainManAmount(TrainQuality train);
}
