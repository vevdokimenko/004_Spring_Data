package com.itvdn.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.itvdn.persistence.dao.services.interfaces.CarSimpleService;
import com.itvdn.persistence.model.Car;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/car")
public class CarController {
    private static final Log LOG = LogFactory.getLog(CarController.class);

    @Autowired
    private CarSimpleService carSimpleService;

    @GetMapping
    public ModelAndView listAllCars(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("cars", carSimpleService.findAll());
        modelAndView.setViewName("views/car/index");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addNewCar(HttpServletRequest request) {
        Car car = new Car();
        car.setModel(request.getParameter("model"));
        car.setMark(request.getParameter("mark"));
        car.setEngine(Double.parseDouble(request.getParameter("engine")));
        car.setPrice(Integer.parseInt(request.getParameter("price")));
        car.setSpeed(Integer.parseInt(request.getParameter("speed")));
        LOG.info("New car with id " + carSimpleService.addCar(car).getId()
                + " was added.");
        return "redirect:/car";
    }

    @PostMapping(value = "/remove")
    public String deleteCar(HttpServletRequest request) {
        carSimpleService.removeById(Long.parseLong(request.getParameter("id")));
        LOG.info("Car with " + request.getParameter("id") + " was removed");
        return "redirect:/car";
    }

    @GetMapping(value = "/findByMark")
    public ModelAndView findCarByMark(@RequestParam("mark") String mark, ModelAndView modelAndView) {

        modelAndView.addObject("cars", carSimpleService.findCarByMark(mark));

        modelAndView.setViewName("/views/car/search-results");
        return modelAndView;
    }

    @GetMapping(value = "/findByMarkAndModelAndSpeed")
    public ModelAndView findByMarkAndModelAndSpeed(@RequestParam("mark") String mark,
                                                   @RequestParam("model") String model,
                                                   @RequestParam("speed") int speed,
                                                   ModelAndView modelAndView) {
        modelAndView.addObject("cars", carSimpleService.findCarByMarkAndModelAndSpeed(
                mark, model, speed
        ));
        modelAndView.setViewName("/views/car/search-results");
        return modelAndView;
    }

    @GetMapping(value = "/deleteAllAudi")
    public String deleteAllAudi(){
        carSimpleService.deleteAllByMark("Audi");
        return "redirect:/car";
    }
}
