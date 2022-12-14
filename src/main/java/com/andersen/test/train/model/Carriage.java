package com.andersen.test.train.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Carriage extends TrainUnit {

  private CarriageType type;

}
