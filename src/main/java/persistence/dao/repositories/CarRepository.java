package persistence.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import persistence.model.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findCarByMark(String mark);
    List<Car> findCarByMarkAndModelAndSpeed(String mark, String model, int speed);
}
