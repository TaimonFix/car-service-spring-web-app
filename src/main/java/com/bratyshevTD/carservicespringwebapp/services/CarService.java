package com.bratyshevTD.carservicespringwebapp.services;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import com.bratyshevTD.carservicespringwebapp.repositories.CarRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.getCars();
    }

    public Car getCarById(int id) {
        return carRepository.getCars().get(id - 1);

    }
}
