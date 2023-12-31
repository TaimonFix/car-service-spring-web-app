package com.bratyshevTD.carservicespringwebapp.repositories;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import com.bratyshevTD.carservicespringwebapp.entities.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarDetailRepository extends JpaRepository<CarDetail, String> {

    @Query("SELECT c FROM CarDetail c WHERE (c.detailID LIKE %:search%) OR (c.title LIKE %:search%)")
    List<CarDetail> find(@Param("search") String search);
    @Query("SELECT c FROM CarDetail c WHERE (c.detailID = :detailID OR :detailID is null) AND (c.title = :title OR :title is null)")
    List<CarDetail> filter(@Param("detailID") String detailID, @Param("title") String title);
}
