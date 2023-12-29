package com.bratyshevTD.carservicespringwebapp.controllers;

import com.bratyshevTD.carservicespringwebapp.entities.*;
import com.bratyshevTD.carservicespringwebapp.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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

    @GetMapping("/car/filter")
    public String filterByCarNumberAndCarBrandAndReleaseDate(@RequestParam(name="carNumber", required=false) String carNumber,
                                                           @RequestParam(name="carBrand", required=false) String carBrand,
                                                           @RequestParam(name="releaseDate", required=false) LocalDate releaseDate,
                                                           Model model) {

        if (carNumber==null && carBrand==null && releaseDate==null) {
            return "redirect:/car";
        }
        model.addAttribute("carNumber", carNumber);
        model.addAttribute("carBrand", carBrand);
        model.addAttribute("releaseDate", releaseDate);
        List<Car> filterCars = carService.filterAllByCarNumberAndCarBrandAndReleaseDate(carNumber, carBrand, releaseDate);
        model.addAttribute("cars", filterCars);
        return "find/findCar";
    }


}
