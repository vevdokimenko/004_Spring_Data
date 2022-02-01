package controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import persistence.dao.services.interfaces.CarSimpleService;
import persistence.model.Car;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/car")
public class CarController {
    private static final Log LOG = LogFactory.getLog(CarController.class);

    @Autowired
    private CarSimpleService carSimpleService;


    @PostMapping(value = "/add")
    public String addNewEmployee(HttpServletRequest request) {
        Car car = new Car();
        car.setModel(request.getParameter("model"));
        car.setMark(request.getParameter("mark"));
        car.setEngine(Double.parseDouble(request.getParameter("engine")));
        car.setPrice(Integer.parseInt(request.getParameter("price")));
        car.setSpeed(Integer.parseInt(request.getParameter("speed")));
        LOG.info("New car with id " + carSimpleService.addCar(car).getId()
                + " was added.");
        return "redirect:/cars/all";
    }

    @GetMapping(value = "/all")
    public ModelAndView listAllCars(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("cars", carSimpleService.findAll());
        modelAndView.setViewName("/cars/all");
        return modelAndView;
    }

    @GetMapping(value = "/remove/{id}")
    public ModelAndView deleteCar(@PathVariable long id, ModelAndView modelAndView) throws InterruptedException {
        carSimpleService.removeById(id);
        modelAndView.addObject("cars", carSimpleService.findAll());
        modelAndView.setViewName("redirect:/cars/all");
        return modelAndView;
    }

    @PostMapping(value = "/findByMark")
    public ModelAndView findCarByMark(@RequestParam("mark") String mark, ModelAndView modelAndView) {

        modelAndView.addObject("cars", carSimpleService.findCarByMark(mark));

        modelAndView.setViewName("/cars/search-results");
        return modelAndView;
    }

    @PostMapping(value = "/findByMarkAndModelAndSpeed")
    public ModelAndView findByMarkAndModelAndSpeed(@RequestParam("mark") String mark,
                                                      @RequestParam("model") String model,
                                                      @RequestParam("speed") int speed,
                                                      ModelAndView modelAndView) {
        modelAndView.addObject("cars", carSimpleService.findCarByMarkAndModelAndSpeed(
                mark, model, speed
        ));
        modelAndView.setViewName("/cars/search-results");
        return modelAndView;
    }

}
