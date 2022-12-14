package com.andersen.test.train.model;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Train implements TrainAble {

  public static final Double ONE_PASSENGER_WEIGHT = 75.0;

  private List<Locomotive> locomotiveList;
  private List<Carriage> carriageList;

  @Override
  public Double getEmptyWeight() {
    return sumDoubleUnitsValues(TrainUnit::getEmptyWeight);
  }

  @Override
  public Double getMaxValuableWeight() {
    return sumDoubleUnitsValues(TrainUnit::getMaxValuableWeight);
  }

  @Override
  public Integer getMaxPassengersAmount() {
    return sumIntUnitsValues(TrainUnit::getMaxPassengerAmount);
  }

  @Override
  public Double getCommonMaxValuableWeight() {
    Double maxValuableWeight = getMaxValuableWeight();
    Double maxPassengersWeight = ONE_PASSENGER_WEIGHT * getMaxPassengersAmount();
    return maxValuableWeight + maxPassengersWeight;
  }

  @Override
  public Double getMaxCommonWeight() {
    Double valuableWeight = getCommonMaxValuableWeight();
    Double weight = getEmptyWeight();
    return weight + valuableWeight;
  }

  @Override
  public Integer getLength() {
    return sumIntUnitsValues(TrainUnit::getLength);
  }

  @Override
  public Integer getPassengerAmount() {
    return sumIntUnitsValues(TrainUnit::getPassengerAmount);
  }

  @Override
  public Double getPullingForce() {
    return locomotiveList.stream()
        .mapToDouble(Locomotive::getPullingForce)
        .sum();
  }

  private Double sumDoubleUnitsValues(Function<? super TrainUnit, Double> function) {
    return Stream.concat(locomotiveList.stream(), carriageList.stream())
        .map(function)
        .mapToDouble(Double::valueOf)
        .sum();
  }

  private Integer sumIntUnitsValues(Function<? super TrainUnit, Integer> function) {
    return Stream.concat(locomotiveList.stream(), carriageList.stream())
        .map(function)
        .filter(Objects::nonNull)
        .mapToInt(Integer::valueOf)
        .sum();
  }

}
