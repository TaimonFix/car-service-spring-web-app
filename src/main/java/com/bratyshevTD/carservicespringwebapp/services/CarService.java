package com.bratyshevTD.carservicespringwebapp.services;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import com.bratyshevTD.carservicespringwebapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public List<Car> find(String search) {
        return carRepository.find(search);
    }

    public List<Car> filter(String carNumber, String carBrand, LocalDate releaseDate) {
        return carRepository.filter(carNumber, carBrand, releaseDate);
    }

    public List<Car> getAllCars() { return carRepository.findAll(); }

    public Car getCarByVin(String vin) {
        return carRepository.getReferenceById(vin);
    }

    public void addCar(Car car) { carRepository.save(car); }

    public void removeCarById(String vin) {
        carRepository.deleteById(vin);
    }
}
