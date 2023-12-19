package com.bratyshevTD.carservicespringwebapp.controllers;

import com.bratyshevTD.carservicespringwebapp.entities.Employee;
import com.bratyshevTD.carservicespringwebapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public String employeePage(Model model) {
        List<Employee> employee = employeeService.getAllEmployees();
        model.addAttribute("employees", employee);
        return "employee";
    }

    @PostMapping("/employee/add")
    public String addEmployee(@RequestParam(required = false) Long employeeID, @RequestParam String fullName,
                              @RequestParam LocalDate birthDate, @RequestParam String address, @RequestParam String phone,
                              @RequestParam String post, @RequestParam String salary, @RequestParam String experience,
                              @RequestParam String bonusSalary, @RequestParam String operatingMode) {
        Employee employee = new Employee(employeeID, fullName, birthDate,
                                        address, phone, post, salary, experience, bonusSalary, operatingMode);
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    @GetMapping("/employee/adds")
    public String addRandomEmployees() throws Exception {
        for (int i = 0; i < 760; i++) {
            Employee employee = new Employee();
            employee.setEmployeeID(null);
            employee.setRandomFullName(new File("testData/fullName/surnames.txt"),
                                       new File("testData/fullName/names.txt"),
                                       new File("testData/fullName/patronymic.txt"));
            employee.setRandomBirthDate();
            employee.setRandomAddress(new File("testData/address/city.txt"),
                                      new File("testData/address/street.txt"));
            employee.setRandomPhone();
            employee.setRandomPost(new File("testData/post.txt"));
            employee.setRandomSalary();
            employee.setRandomExperience();
            employee.setRandomBonusSalary();
            employee.setRandomOperatingMode();

            employeeService.addEmployee(employee);
        }
        return "redirect:/employee";
    }
}
