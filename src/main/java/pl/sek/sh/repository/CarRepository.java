package pl.sek.sh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sek.sh.entity.Car;

@Repository
public interface CarRepository extends JpaRepository <Car,Long> {

}
