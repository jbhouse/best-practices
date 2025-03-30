package com.moorhouse.adapters;

import com.moorhouse.Ford;

public class FordAdapter implements Vehicle {
  private final Ford ford;
  public FordAdapter(Ford ford) {
    this.ford = ford;
  }

  @Override
  public Integer getPrice() {
    return ford.getBasePrice() - ford.getRebate();
  }

  @Override
  public String getModel() {
    return ford.getModel();
  }
}
