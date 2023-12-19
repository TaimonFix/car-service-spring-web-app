package com.bratyshevTD.carservicespringwebapp.services;


import com.bratyshevTD.carservicespringwebapp.entities.Employee;
import com.bratyshevTD.carservicespringwebapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() { return employeeRepository.findAll(); }

    public void addEmployee(Employee employee) { employeeRepository.save(employee); }

    public void deleteEmployeeById(Long id) { employeeRepository.deleteById(id);}
}
