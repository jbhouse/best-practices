package com.moorhouse.models;

import com.moorhouse.Honda;

public class HondaAdapter implements Vehicle {
  private final Honda honda;

  public HondaAdapter(Honda honda) {
    this.honda = honda;
  }

  @Override
  public Integer getPrice() {
    return honda.getBasePrice() + honda.getTariff();
  }

  @Override
  public String getModel() {
    return honda.getModel();
  }
}
