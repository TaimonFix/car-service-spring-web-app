package com.bratyshevTD.carservicespringwebapp.controllers;

import com.bratyshevTD.carservicespringwebapp.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {




    @GetMapping("/index")
    public String homePage() {
        return "index";
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




//    @GetMapping("/car/{id}")
//    public String carPage(Model model, @PathVariable("id") int id) {
//
//        Car selectedCar = carService.getCarById(id);
//        model.addAttribute("car", selectedCar);
//        return "car";
//    }



//    @GetMapping("/car-order")
//    public String carOrderPage(Model model) {
//        CarOrder carOrder = new CarOrder(1, 1, "xta", "22.11.2023", "23.11.2023", "-", 1, 1);
//        model.addAttribute("carOrder", carOrder);
//        return "car-order";
//    }
}
