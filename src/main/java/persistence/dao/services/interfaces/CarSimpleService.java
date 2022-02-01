package persistence.dao.services.interfaces;

import persistence.model.Car;

import java.util.List;

public interface CarSimpleService {
    List<Car> findAll() throws InterruptedException;

    Car addCar(Car car);

    void removeById(long id);

    List<Car> findCarByMark(String mark);

    List<Car> findCarByMarkAndModelAndSpeed(String mark, String model, int speed);
}
