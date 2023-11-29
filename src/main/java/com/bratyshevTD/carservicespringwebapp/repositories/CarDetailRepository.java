package com.bratyshevTD.carservicespringwebapp.repositories;

import com.bratyshevTD.carservicespringwebapp.entities.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailRepository extends JpaRepository<CarDetail, String> {
}
