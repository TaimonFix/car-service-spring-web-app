package com.bratyshevTD.carservicespringwebapp.controllers;

import com.bratyshevTD.carservicespringwebapp.entities.*;
import com.bratyshevTD.carservicespringwebapp.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car")
    public String carsPage(Model model) {
        List<Car> allCars = carService.getAllCars();
        int size = allCars.size();
        model.addAttribute("cars", allCars);
        return "car";
    }

    @PostMapping("/car/add")
    public String addCar(@RequestParam String vin, @RequestParam String carNumber, @RequestParam String carBrand, @RequestParam(required = false) LocalDate releaseDate) {
        Car car = new Car(vin, carNumber, carBrand, releaseDate);
        carService.addCar(car);
        return "redirect:/car";
    }

    @GetMapping("/car/delete/{vin}")
    public String deleteCarByVin(@PathVariable("vin") String vin) {
        carService.removeCarById(vin);
        return "redirect:/car";
    }

    @GetMapping("/car/findByCarNumber")
    public String filterAllByCarNumber(@RequestParam("carNumber") String carNumber, Model model) {
        List<Car> findCars = carService.filterAllByCarNumber(carNumber);
        model.addAttribute("cars", findCars);
        return "find/findCar";
    }

    @GetMapping("/car/findByCarBrand")
    public String filterAllByCarBrand(@RequestParam("carBrand") String carBrand, Model model) {
        List<Car> findCars = carService.filterAllByCarBrand(carBrand);
        model.addAttribute("cars", findCars);
        return "find/findCar";
    }

    @GetMapping("/car/findByReleaseDate")
    public String filterAllByReleaseDate(@RequestParam("releaseDate") LocalDate releaseDate, Model model) {
        List<Car> findCars = carService.filterAllByReleaseDate(releaseDate);
        model.addAttribute("cars", findCars);
        return "find/findCar";
    }


}
