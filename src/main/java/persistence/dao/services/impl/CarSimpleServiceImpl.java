package persistence.dao.services.impl;

import com.google.common.collect.Lists;
import persistence.dao.repositories.CarRepository;
import persistence.dao.services.interfaces.CarSimpleService;
import persistence.model.Car;

import java.util.List;

public class CarSimpleServiceImpl implements CarSimpleService {
    private CarRepository carRepository;


    public List<Car> findAll() throws InterruptedException {
        return Lists.newArrayList(carRepository.findAll());
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public void removeById(long id) {
        carRepository.deleteById(id);
    }

    public List<Car> findCarByMark(String mark) {
        return carRepository.findCarByMark(mark);
    }

    public List<Car> findCarByMarkAndModelAndSpeed(String mark, String model, int speed) {
        return carRepository.findCarByMarkAndModelAndSpeed(mark, model, speed);
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
