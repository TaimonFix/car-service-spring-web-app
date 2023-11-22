package com.bratyshevTD.carservicespringwebapp.repositories;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarRepository {

    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    @PostConstruct
    public void init() {
        cars = new ArrayList<>();
        cars.add(new Car("xta201", "o000o36", "bmw", "01.01.2023"));
        cars.add(new Car("xta202", "o002o36", "mercedes", "01.02.2023"));
        cars.add(new Car("xta203", "o003o36", "toyota", "01.03.2023"));
    }
}
