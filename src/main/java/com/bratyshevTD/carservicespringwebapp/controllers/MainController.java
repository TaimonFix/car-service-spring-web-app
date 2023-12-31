package com.bratyshevTD.carservicespringwebapp.controllers;

import com.bratyshevTD.carservicespringwebapp.entities.*;
import com.bratyshevTD.carservicespringwebapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private CarService carService;
    private CarDetailService carDetailService;
    private ClientService clientService;
    private EmployeeService employeeService;
    private CarOrderService carOrderService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
    @Autowired
    public void setCarDetailService(CarDetailService carDetailService) {
        this.carDetailService = carDetailService;
    }
    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Autowired
    public void setCarOrderService(CarOrderService carOrderService) {
        this.carOrderService = carOrderService;
    }

    @GetMapping("/index")
    public String homePage(Model model) {
        long carSize = carService.getAllCars().size();
        long carDetailSize = carDetailService.getAllCarDetails().size();
        long clientSize = clientService.getAllClients().size();
        long employeeSize = employeeService.getAllEmployees().size();
        long carOrderSize = carOrderService.getAllCarOrders().size();

        model.addAttribute("carSize", carSize);
        model.addAttribute("carDetailSize", carDetailSize);
        model.addAttribute("clientSize", clientSize);
        model.addAttribute("employeeSize", employeeSize);
        model.addAttribute("carOrderSize", carOrderSize);

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
