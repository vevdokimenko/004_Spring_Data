package com.itvdn.persistence.dao.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import com.itvdn.persistence.dao.repositories.CarRepository;
import com.itvdn.persistence.dao.services.interfaces.CarSimpleService;
import com.itvdn.persistence.model.Car;

import java.util.List;

@Service
public class CarSimpleServiceImpl implements CarSimpleService {
    private CarRepository carRepository;

    @Cacheable("cars")
    public List<Car> findAll() throws InterruptedException {
        long sleepingTime = 3000;
        System.out.printf("Start sleeping for %d s...\n", sleepingTime);
        Thread.sleep(sleepingTime);
        return Lists.newArrayList(carRepository.findAll());
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public void removeById(long id) {
        carRepository.deleteById(id);
    }

    @CachePut(value = "car", condition = "#result != null", key = "#result")
    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
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

    @CacheEvict({"cars", "car"})
    @Override
    public void clearCache() {
        System.out.println("Cache cars cleared");
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
