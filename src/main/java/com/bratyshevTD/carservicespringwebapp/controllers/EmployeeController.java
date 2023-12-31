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

    @GetMapping("/employee/find")
    public String find(@RequestParam(name="search", required = false) String search, Model model) {
        if (search == "") {
            return "redirect:/employee";
        }
        List<Employee> employees = employeeService.find(search);
        model.addAttribute("employees", employees);
        return "find/findEmployee";
    }

    @GetMapping("/employee/filter")
    public String filter(@RequestParam(name="employeeID", required = false) Long employeeID, @RequestParam(name="fullName", required = false) String fullName,
                         @RequestParam(name="birthDate", required = false) LocalDate birthDate, @RequestParam(name="address", required = false) String address,
                         @RequestParam(required = false) String phone, @RequestParam(name="post", required = false) String post,
                         @RequestParam(name="salary", required = false) String salary, @RequestParam(name="experience", required = false) String experience,
                         @RequestParam(name="bonusSalary", required = false) String bonusSalary, @RequestParam(name="operatingMode", required = false) String operatingMode, Model model) {
        if (employeeID == null && fullName == null && birthDate == null && address == null && phone == null
        && post == null && salary == null && experience == null && bonusSalary == null && operatingMode == null) {
            return "redirect:/employee";
        }
        model.addAttribute("employeeID", employeeID);
        model.addAttribute("fullName", fullName);
        model.addAttribute("birthDate", birthDate);
        model.addAttribute("address", address);
        model.addAttribute("phone", phone);
        model.addAttribute("post", post);
        model.addAttribute("salary", salary);
        model.addAttribute("experience", experience);
        model.addAttribute("bonusSalary", bonusSalary);
        model.addAttribute("operatingMode", operatingMode);
        List<Employee> employees = employeeService.filter(employeeID, fullName, birthDate, address, phone, post, salary, experience, bonusSalary, operatingMode);
        model.addAttribute("employees", employees);
        return "filter/filterEmployee";
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
