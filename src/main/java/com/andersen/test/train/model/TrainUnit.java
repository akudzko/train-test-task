package com.andersen.test.train.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class TrainUnit {

  private String uid;
  private String producer;
  private BigDecimal emptyWeight;
  private Integer length;
  private Integer passengerAmount;
  private Integer maxPassengerAmount;
  private BigDecimal maxValuableWeight;
  private LocalDate productionDate;
  private BigDecimal valuableWeight;
  private Train train;

}
