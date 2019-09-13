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
import java.util.Optional;

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

    @Override
    public ResponseEntity<HttpStatus> delete(Long id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if(carOptional.isPresent()){
            log.info("Car was deleted: " + carOptional);
            carRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            log.info("There is no car in data base with id: " + id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
