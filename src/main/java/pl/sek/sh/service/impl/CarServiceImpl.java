package pl.sek.sh.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sek.sh.entity.Car;
import pl.sek.sh.repository.CarRepository;
import pl.sek.sh.service.CarService;

import javax.validation.ConstraintViolationException;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public ResponseEntity<HttpStatus> save(Car car) {
        try {
            carRepository.save(car);
        } catch (ConstraintViolationException e) {
            log.error("All data for car save need to be not null");
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }
        log.info("Saved car:" + car);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<Car>> getAllCars() {
        if (carRepository.findAll().size() == 0) {
            log.info("Requested empty car list");
            return new ResponseEntity<>(carRepository.findAll(), HttpStatus.NO_CONTENT);
        } else {
            log.info("Sent list of all cars ... ");
            return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
        }
    }
}
