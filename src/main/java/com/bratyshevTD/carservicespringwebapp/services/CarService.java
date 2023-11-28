package com.bratyshevTD.carservicespringwebapp.services;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import com.bratyshevTD.carservicespringwebapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(String id) {
        return carRepository.getOne(id);
    }

    public void removeCarById(String id) {
        carRepository.deleteById(id);
    }
}
