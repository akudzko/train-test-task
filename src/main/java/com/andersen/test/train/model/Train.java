package com.andersen.test.train.model;

import static com.andersen.test.train.util.Constants.ONE_PASSENGER_WEIGHT;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import lombok.Data;

@Data
public class Train implements TrainQuality {

  private List<TrainUnit> unitList;

  @Override
  public BigDecimal getEmptyWeight() {
    return sumBigDecimalUnitsValues(TrainUnit::getEmptyWeight);
  }

  @Override
  public BigDecimal getMaxValuableWeight() {
    return sumBigDecimalUnitsValues(TrainUnit::getMaxValuableWeight);
  }

  @Override
  public Integer getMaxPassengersAmount() {
    return sumIntUnitsValues(TrainUnit::getMaxPassengerAmount);
  }

  @Override
  public BigDecimal getCommonMaxValuableWeight() {
    BigDecimal maxValuableWeight = getMaxValuableWeight();
    BigDecimal maxPassengersWeight = ONE_PASSENGER_WEIGHT.multiply(BigDecimal.valueOf(getMaxPassengersAmount()));
    return maxValuableWeight.add(maxPassengersWeight);
  }

  @Override
  public BigDecimal getMaxCommonWeight() {
    BigDecimal valuableWeight = getCommonMaxValuableWeight();
    BigDecimal weight = getEmptyWeight();
    return weight.add(valuableWeight);
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
  public BigDecimal getPullingForce() {
    return unitList.stream()
        .filter(Locomotive.class::isInstance)
        .map(Locomotive.class::cast)
        .map(Locomotive::getPullingForce)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private BigDecimal sumBigDecimalUnitsValues(Function<? super TrainUnit, BigDecimal> function) {
    return unitList.stream()
        .map(function)
        .reduce(BigDecimal.ZERO,BigDecimal::add);
  }

  private Integer sumIntUnitsValues(Function<? super TrainUnit, Integer> function) {
    return unitList.stream()
        .map(function)
        .filter(Objects::nonNull)
        .mapToInt(Integer::valueOf)
        .sum();
  }

}
