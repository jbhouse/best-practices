package com.moorhouse;

import com.moorhouse.adapters.Vehicle;

import java.util.Optional;

public interface Carfactory {
  Optional<Vehicle> getCarByMake(String make);
}
