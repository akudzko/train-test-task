package com.andersen.test.train.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Locomotive extends TrainUnit {

  private LocomotiveType type;
  private Double pullingForce;

}
