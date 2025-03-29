package com.moorhouse;

import com.moorhouse.models.FordAdapter;
import com.moorhouse.models.HondaAdapter;
import com.moorhouse.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarFactory {
  private final ExternalCarApi externalCarApi;
  public CarFactory(ExternalCarApi externalCarApi) {
    this.externalCarApi = externalCarApi;
  }
  public Optional<Vehicle> getCarByMake(Make make) {
    return switch (make) {
      case Make.FORD -> Optional.of(new FordAdapter(externalCarApi.getFord()));
      case Make.HONDA -> Optional.of(new HondaAdapter(externalCarApi.getHonda()));
      case null -> Optional.empty();
    };
  }
}
