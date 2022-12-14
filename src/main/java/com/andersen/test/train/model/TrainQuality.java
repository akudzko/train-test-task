package com.andersen.test.train.model;

import java.math.BigDecimal;

public interface TrainQuality {

  BigDecimal getEmptyWeight();

  BigDecimal getMaxValuableWeight();

  Integer getMaxPassengersAmount();

  BigDecimal getCommonMaxValuableWeight();

  BigDecimal getMaxCommonWeight();

  Integer getLength();

  Integer getPassengerAmount();

  BigDecimal getPullingForce();
}
