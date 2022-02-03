package com.itvdn.controllers;

import com.itvdn.persistence.model.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-simple-ctx.xml"})
public class UnitTester {
    @Autowired
    private List<Car> carList;

    @Autowired
    @Qualifier(value = "car1")
    private Car car;

    @Test
    public void testCar(){
        Assert.assertEquals("Opel", car.getMark());
    }

    @Test
    public void testCar2() {
        Assert.assertEquals(4, carList.size());
    }

    @Test
    public void testCar3() {
        Assert.assertEquals(7000, carList.get(3).getPrice());
    }
}
