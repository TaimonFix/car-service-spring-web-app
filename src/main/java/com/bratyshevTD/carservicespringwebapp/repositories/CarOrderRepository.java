package com.bratyshevTD.carservicespringwebapp.repositories;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import com.bratyshevTD.carservicespringwebapp.entities.CarOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {

    @Query("SELECT c FROM CarOrder c WHERE c.clientID=null AND c.vin=null AND c.detailID = null AND c.employeeID = null")
    List<CarOrder> filterWithoutRelationToOtherTables();

}
