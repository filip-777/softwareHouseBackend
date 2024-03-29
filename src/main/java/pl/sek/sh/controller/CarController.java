package pl.sek.sh.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sek.sh.entity.Car;
import pl.sek.sh.service.CarService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveCar(@RequestBody Car car){
        return carService.save(car);
    }

    @GetMapping("/fetchAll")
    @ResponseBody
    public ResponseEntity<List<Car>> fetchAll(){
        return carService.getAllCars();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
        return carService.delete(id);
    }

}
