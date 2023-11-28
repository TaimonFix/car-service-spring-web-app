package com.bratyshevTD.carservicespringwebapp.controllers;

import com.bratyshevTD.carservicespringwebapp.entities.*;
import com.bratyshevTD.carservicespringwebapp.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {


    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/car")
    public String carsPage(Model model) {
        List<Car> allCars = carService.getAllCars();
        model.addAttribute("cars", allCars);
        return "car";
    }

    @PostMapping("/car/add")
    public String addCar(@RequestParam String vin, @RequestParam String carNumber, @RequestParam String carBrand, @RequestParam LocalDate releaseDate) {
        Car car = new Car(vin, carNumber, carBrand, releaseDate);
        carService.addCar(car);
        return "redirect:/car";
    }

//    @GetMapping("/car/adds")
//    public void addCars() throws Exception {
//        for (int i = 0; i < 1000; i++) {
//            Car car = new Car();
//            car.setRandomVin();
//            car.setRandomNumber();
//            car.setRandomBrand(new File("testData/car/carModels.txt"));
//            car.setRandomReleaseDate();
//            carService.addRandomCars(car);
//        }
//    }



    @GetMapping("/car/delete/{vin}")
    public String removeCarByVin(@PathVariable("vin") String vin) {
        carService.removeCarById(vin);
        return "redirect:/car";
    }
//    @GetMapping("/car/{id}")
//    public String carPage(Model model, @PathVariable("id") int id) {
//
//        Car selectedCar = carService.getCarById(id);
//        model.addAttribute("car", selectedCar);
//        return "car";
//    }

    @GetMapping("/car-detail")
    public String carDetailPage(Model model) {
        CarDetail carDetail = new CarDetail("vtb-201", "Запчасть");
        model.addAttribute("carDetail", carDetail);
        return "car-detail";
    }

    @GetMapping("/car-order")
    public String carOrderPage(Model model) {
        CarOrder carOrder = new CarOrder(1, 1, "xta", "22.11.2023", "23.11.2023", "-", 1, 1);
        model.addAttribute("carOrder", carOrder);
        return "car-order";
    }

    @GetMapping("/client")
    public String clientPage(Model model) {
        Client client = new Client(100, "Иванов Иван Иванович", "88005553535");
        model.addAttribute("client", client);
        return "client";
    }

    @GetMapping("/employee")
    public String employeePage(Model model) {
        Employee employee = new Employee(1, "", "", "", "", "", "", "", "", "");
        model.addAttribute("employee", employee);
        return "employee";
    }
}
