package com.bratyshevTD.carservicespringwebapp.repositories;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    boolean existsByCarNumber(String carNumber);
    boolean existsByCarBrand(String carBrand);
    boolean existsByReleaseDate(LocalDate releaseDate);

    List<Car> findAllByCarNumber(String carNumber);
    List<Car> findAllByCarBrand(String carBrand);
    List<Car> findAllByReleaseDate(LocalDate releaseDate);


    @Query("SELECT c FROM Car c WHERE (c.carNumber = :carNumber OR :carNumber is null) AND (c.carBrand = :carBrand OR :carBrand is null) AND (c.releaseDate = :releaseDate OR CAST(:releaseDate AS date) is null)")
    List<Car> filter(@Param("carNumber") String carNumber, @Param("carBrand") String carBrand, @Param("releaseDate") LocalDate releaseDate);

//    List<Car> findByCarNumberAndCarBrandAndReleaseDate(String carNumber, String carBrand, LocalDate releaseDate);
}
