package com.bratyshevTD.carservicespringwebapp.controllers;

import com.bratyshevTD.carservicespringwebapp.entities.CarDetail;
import com.bratyshevTD.carservicespringwebapp.services.CarDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@Controller
public class CarDetailController {

private CarDetailService carDetailService;

    @Autowired
    public void setCarDetailService(CarDetailService carDetailService) {
        this.carDetailService = carDetailService;
    }

    @GetMapping("/car-detail")
    public String carDetailPage(Model model) {
        List<CarDetail> carDetail = carDetailService.getAllCarDetails();
        model.addAttribute("carDetails", carDetail);
        return "car-detail";
    }


    @PostMapping("/car-detail/add")
    public String addCarDetail(@RequestParam String detailID, @RequestParam String title) {
        CarDetail carDetail = new CarDetail(detailID, title);
        carDetailService.addCarDetail(carDetail);
        return "redirect:/car-detail";
    }

    @GetMapping("/car-detail/delete/{id}")
    public String deleteCarDetailById(@PathVariable("id") String id) {
        carDetailService.removeById(id);
        return "redirect:/car-detail";
    }

    @GetMapping("/car-detail/find")
    public String find(@RequestParam(required = false) String search, Model model) {
        if (search == "") {
            return "redirect:/car-detail";
        }
        model.addAttribute("search", search);
        List<CarDetail> carDetails = carDetailService.find(search);
        model.addAttribute("carDetails", carDetails);
        return "find/findCarDetail";
    }

    @GetMapping("/car-detail/filter")
    public String filter(@RequestParam(name="detailID", required = false) String detailID, @RequestParam(name="title", required = false) String title, Model model) {
        if (detailID == null && title == null) {
            return "redirect:/car-detail";
        }
        model.addAttribute("detailID", detailID);
        model.addAttribute("title", title);
        List<CarDetail> carDetails = carDetailService.filter(detailID, title);
        model.addAttribute("carDetails", carDetails);
        return "filter/filterCarDetail";
    }

//    @GetMapping("/car-detail/adds")
//    public String addRandomCarDetails() throws Exception {
//
//        for (int i = 0; i < 1000; i++) {
//            CarDetail carDetail = new CarDetail();
//            carDetail.setRandomDetailID();
//            carDetail.setRandomTitle(new File("testData/car/carDetails.txt"));
//            carDetailService.addCarDetail(carDetail);
//        }
//        return "redirect:/car-detail";
//    }
}
