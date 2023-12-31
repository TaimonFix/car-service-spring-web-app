package com.bratyshevTD.carservicespringwebapp.repositories;

import com.bratyshevTD.carservicespringwebapp.entities.Car;
import com.bratyshevTD.carservicespringwebapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT c FROM Employee c WHERE (CAST(c.employeeID AS String) LIKE %:search%) OR (c.fullName LIKE %:search%) OR (CAST(c.birthDate AS String) LIKE %:search%) OR (c.address LIKE %:search%) " +
            "OR (c.phone LIKE %:search%) OR (c.post LIKE %:search%) OR (c.salary LIKE %:search%) OR (c.experience LIKE %:search%)" +
            " OR (c.bonusSalary LIKE %:search%) OR (c.operatingMode LIKE %:search%)")
    List<Employee> find(@Param("search") String search);
    @Query("SELECT c FROM Employee c WHERE (c.employeeID = :employeeID OR :employeeID is null) AND (c.fullName = :fullName OR :fullName is null) AND (c.birthDate = :birthDate OR CAST(:birthDate AS date) is null)" +
            "AND (c.address = :address OR :address is null) AND (c.phone = :phone OR :phone is null) AND (c.post = :post OR :post is null) AND (c.salary = :salary OR :salary is null)" +
            "AND (c.experience = :experience OR :experience is null) AND (c.bonusSalary = :bonusSalary OR :bonusSalary is null) AND (c.operatingMode = :operatingMode OR :operatingMode is null)")
    List<Employee> filter(@Param("employeeID") Long employeeID, @Param("fullName") String fullName, @Param("birthDate") LocalDate birthDate,
                     @Param("address") String address, @Param("phone") String phone, @Param("post") String post,
                     @Param("salary") String salary, @Param("experience") String experience, @Param("bonusSalary") String bonusSalary,
                     @Param("operatingMode") String operatingMode);
}
