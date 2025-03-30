package com.moorhouse;

import com.moorhouse.adapters.FordAdapter;
import com.moorhouse.adapters.HondaAdapter;
import com.moorhouse.adapters.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarFactoryImpl implements Carfactory {
  private final ExternalCarApi externalCarApi;
  public CarFactoryImpl(ExternalCarApi externalCarApi) {
    this.externalCarApi = externalCarApi;
  }
  public Optional<Vehicle> getCarByMake(String make) {
    return switch (make) {
      case "ford" -> Optional.of(new FordAdapter(externalCarApi.getFord()));
      case "honda" -> Optional.of(new HondaAdapter(externalCarApi.getHonda()));
      case null,default -> Optional.empty();
    };
  }
}
