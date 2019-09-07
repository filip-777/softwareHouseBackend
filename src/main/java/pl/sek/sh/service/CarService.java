package pl.sek.sh.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.sek.sh.entity.Car;

import java.util.List;

public interface CarService {

    ResponseEntity<HttpStatus> save(Car car);
    ResponseEntity<List<Car>> getAllCars();

}
