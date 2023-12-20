package com.bratyshevTD.carservicespringwebapp.repositories;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    boolean existsByCarNumber(String carNumber);
    boolean existsByCarBrand(String carBrand);
    boolean existsByReleaseDate(LocalDate releaseDate);

    List<Car> findAllByCarNumber(String carNumber);
    List<Car> findAllByCarBrand(String carBrand);
    List<Car> findAllByReleaseDate(LocalDate releaseDate);
    List<Car> findAllByCarNumberAndCarBrandAndReleaseDate(String carNumber, String carBrand, LocalDate releaseDate);
}
