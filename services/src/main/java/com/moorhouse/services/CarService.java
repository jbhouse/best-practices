package com.moorhouse.services;

import com.moorhouse.*;
import com.moorhouse.models.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService implements CarApiDelegate {
  private final Logger log = LoggerFactory.getLogger(CarService.class);
  private final CarFactory carFactory;
  public CarService(CarFactory carFactory) {
    this.carFactory = carFactory;
  }
  @Override
  public ResponseEntity<Car> getCar(Make make) {
    log.info("Handling request to get car by make: {}", make);
    try {
      Optional<Vehicle> vehicle = carFactory.getCarByMake(make);
      if (vehicle.isPresent()) {
        return new ResponseEntity<>(new Car(vehicle.get().getPrice(), vehicle.get().getModel()), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
