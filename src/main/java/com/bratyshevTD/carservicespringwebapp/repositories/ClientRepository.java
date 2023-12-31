package com.bratyshevTD.carservicespringwebapp.repositories;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import com.bratyshevTD.carservicespringwebapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE (CAST(c.clientID AS String) LIKE %:search%) OR (c.fullName LIKE %:search%) OR (c.phone LIKE %:search%)")
    List<Client> find(@Param("search") String search);
    @Query("SELECT c FROM Client c WHERE (c.clientID = :clientID OR :clientID is null) AND (c.fullName = :fullName OR :fullName is null) AND (c.phone = :phone OR :phone is null)")
    List<Client> filter(@Param("clientID") Long clientID, @Param("fullName") String fullName, @Param("phone") String phone);
}
