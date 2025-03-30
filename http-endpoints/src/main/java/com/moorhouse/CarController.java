package com.moorhouse;

import com.moorhouse.adapters.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CarController implements CarApi {
  private final Carfactory carFactory;
  public CarController(Carfactory carFactory) {
    this.carFactory = carFactory;
  }
  @Override
  public ResponseEntity<Car> getCar(String make) {
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
