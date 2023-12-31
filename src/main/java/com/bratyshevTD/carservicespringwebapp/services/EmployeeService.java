package com.bratyshevTD.carservicespringwebapp.services;


import com.bratyshevTD.carservicespringwebapp.entities.Employee;
import com.bratyshevTD.carservicespringwebapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() { return employeeRepository.findAll(); }

    public Employee getEmployeeById(Long id) { return employeeRepository.getReferenceById(id); }

    public void addEmployee(Employee employee) { employeeRepository.save(employee); }

    public void deleteEmployeeById(Long id) { employeeRepository.deleteById(id);}

    public List<Employee> find(String search) { return employeeRepository.find(search); }

    public List<Employee> filter(Long employeeID, String fullName, LocalDate birthDate, String address, String phone, String post, String salary, String experience,
                                 String bonusSalary, String operatingMode) { return employeeRepository.filter(employeeID, fullName, birthDate,
            address, phone, post, salary, experience, bonusSalary, operatingMode); }
}
