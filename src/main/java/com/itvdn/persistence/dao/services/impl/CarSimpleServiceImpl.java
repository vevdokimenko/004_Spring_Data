package com.itvdn.persistence.dao.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itvdn.persistence.dao.repositories.CarRepository;
import com.itvdn.persistence.dao.services.interfaces.CarSimpleService;
import com.itvdn.persistence.model.Car;

import java.util.List;

@Service
public class CarSimpleServiceImpl implements CarSimpleService {
    private CarRepository carRepository;

    public List<Car> findAll() {
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

    @Override
    public void deleteAllByMark(String mark) {
        carRepository.deleteAllByMark(mark);
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
