package com.bratyshevTD.carservicespringwebapp.services;

import com.bratyshevTD.carservicespringwebapp.entities.CarDetail;
import com.bratyshevTD.carservicespringwebapp.repositories.CarDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDetailService {

    private CarDetailRepository carDetailRepository;

    @Autowired
    public void setCarDetailRepository(CarDetailRepository carDetailRepository) {
        this.carDetailRepository = carDetailRepository;
    }

    public List<CarDetail> getAllCarDetails() {
        return carDetailRepository.findAll();
    }

    public CarDetail getCarDetailById(String id) { return carDetailRepository.getReferenceById(id); }

    public void addCarDetail(CarDetail carDetail) { carDetailRepository.save(carDetail); }

    public void removeById(String id) { carDetailRepository.deleteById(id); }
}
