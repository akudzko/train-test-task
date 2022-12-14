package com.andersen.test.train.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class TrainUnit {

  private String uid;
  private String producer;
  private Double emptyWeight;
  private Integer length;
  private Integer passengerAmount;
  private Integer maxPassengerAmount;
  private Double maxValuableWeight;
  private LocalDate productionDate;
  private Double valuableWeight;
  private Train train;

}
