package com.bratyshevTD.carservicespringwebapp.services;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import com.bratyshevTD.carservicespringwebapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

//    public boolean existsById(String id) { return carRepository.existsById(id); }
//
//    public boolean existsByTitle(String title) { return carRepository.existsByTitle(title); }
//
    public List<Car> filterAllByCarNumber(String carNumber) {return  carRepository.findAllByCarNumber(carNumber); }
    public List<Car> filterAllByCarBrand(String carBrand) {return  carRepository.findAllByCarBrand(carBrand); }
    public List<Car> filterAllByReleaseDate(LocalDate releaseDate) {return  carRepository.findAllByReleaseDate(releaseDate); }

    public List<Car> getAllCars() { return carRepository.findAll(); }

    public Car getCarByVin(String vin) {
        return carRepository.getReferenceById(vin);
    }

    public void addCar(Car car) { carRepository.save(car); }

    public void removeCarById(String vin) {
        carRepository.deleteById(vin);
    }
}
