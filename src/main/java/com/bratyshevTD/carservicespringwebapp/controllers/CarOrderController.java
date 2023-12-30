package com.bratyshevTD.carservicespringwebapp.controllers;


import com.bratyshevTD.carservicespringwebapp.entities.*;
import com.bratyshevTD.carservicespringwebapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CarOrderController {

    private CarOrderService carOrderService;
    private CarService carService;
    private ClientService clientService;
    private CarDetailService carDetailService;
    private EmployeeService employeeService;

    @Autowired
    public void setCarOrderService(CarOrderService carOrderService) {
        this.carOrderService = carOrderService;
    }
    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
    @Autowired
    public void setCarDetailService(CarDetailService carDetailService) {
        this.carDetailService = carDetailService;
    }
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/car-order")
    public String carOrdersPage(Model model) {
        List<CarOrder> carOrders = carOrderService.getAllCarOrders();
        model.addAttribute("carOrders", carOrders);
        return "car-order";
    }

    @PostMapping("/car-order/add")
    public String addCarOrder(@RequestParam(required = false) Long orderId,
                              @RequestParam Long clientId,
                              @RequestParam String vin,
                              @RequestParam(required = false) LocalDate orderDate,
                              @RequestParam(required = false) LocalDate correctionDate,
                              @RequestParam String reason,
                              @RequestParam(required = false) String detailId,
                              @RequestParam(required = false) Long employeeId) {

        Client client = clientService.getClientById(clientId);
        Car car = carService.getCarByVin(vin);
        CarDetail carDetail = carDetailService.getCarDetailById(detailId);
        Employee employee = employeeService.getEmployeeById(employeeId);
        CarOrder carOrder = new CarOrder(orderId, client, car, orderDate, correctionDate, reason, carDetail, employee);
        carOrderService.addCarOrder(carOrder);
        return "redirect:/car-order";
    }

    @GetMapping("/car-order/delete{id}")
    public String deleteCarOrderById(@PathVariable("id") Long id) {
        carOrderService.removeCarOrderById(id);
        return "redirect:/car-order";
    }

    @GetMapping("/car-order/filter")
    public String filterWithoutRelationToOtherTables(Model model) {
        List<CarOrder> carOrders = carOrderService.filterWithoutRelationToOtherTables();
        model.addAttribute("carOrders", carOrders);
        return "filter/filterCarOrderWithoutRelations";
    }
}
