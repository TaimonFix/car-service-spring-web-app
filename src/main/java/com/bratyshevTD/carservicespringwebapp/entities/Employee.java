package com.bratyshevTD.carservicespringwebapp.entities;

import jakarta.persistence.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @OneToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeID;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "post")
    private String post;

    @Column(name = "salary")
    private String salary;

    @Column(name = "experience")
    private String experience;

    @Column(name = "bonus_salary")
    private String bonusSalary;

    @Column(name = "operating_mode")
    private String operatingMode;

    public Employee() {
    }

    public Employee(Long employeeID, String fullName, LocalDate birthDate, String address,
                    String phone, String post, String salary, String experience,
                    String bonusSalary, String operatingMode) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.post = post;
        this.salary = salary;
        this.experience = experience;
        this.bonusSalary = bonusSalary;
        this.operatingMode = operatingMode;
    }

    private ArrayList<String> getList(File file) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()) {
            list.add(bufferedReader.readLine());
        }

        return list;
    }
    public void setRandomFullName(File surnameFile, File nameFile, File patronymicFile) throws Exception {
        ArrayList<String> surnameList = getList(surnameFile);
        ArrayList<String> nameList = getList(nameFile);
        ArrayList<String> patronymicList = getList(patronymicFile);
        Random r =  new Random();

        this.fullName = surnameList.get(r.nextInt(surnameList.size())) +" "+
                nameList.get(r.nextInt(nameList.size())) +" "+
                patronymicList.get(r.nextInt(patronymicList.size()));
    }

    public void setRandomBirthDate() {
        Random r =  new Random();
        int day = 1 + r.nextInt(30);
        int month = 1 + r.nextInt(12);
        int year = 1950 + r.nextInt(44);

        if (month == 2 && day > 28) {
            day-=1;
        }

        this.birthDate = LocalDate.of(year, month, day);
    }

    public void setRandomAddress(File cityFile, File streetFile) throws Exception{
        ArrayList<String> cityList = getList(cityFile);
        ArrayList<String> streetList = getList(streetFile);
        Random r =  new Random();

        String city = cityList.get(r.nextInt(cityList.size()));
        String street = streetList.get(r.nextInt(streetList.size()));
        String home = String.valueOf(r.nextInt(150));

        this.address = "г." + city + "," + street + ", д." + home;
    }

    public void setRandomPhone() {
        Random r =  new Random();
        String str1 = String.valueOf(r.nextInt(100));
        String str2 = String.valueOf(r.nextInt(1000));
        String str3 = String.valueOf(r.nextInt(100));
        String str4 = String.valueOf(r.nextInt(100));

        if (str1.length() == 1) {
            str1 = 0 + str1;
        } else if (str1.isEmpty()) {
            str1 = "00";
        }

        if (str2.length() == 1) {
            str2 = "00" + str2;
        } else if (str2.length() == 2) {
            str2 = 0 + str2;
        } else if (str2.isEmpty()) {
            str2 = "000";
        }

        if (str3.length() == 1) {
            str3 = 0 + str3;
        } else if (str3.isEmpty()) {
            str3 = "00";
        }

        if (str4.length() == 1) {
            str4 = 0 + str4;
        } else if (str4.isEmpty()) {
            str4 = "00";
        }
        this.phone = "+7" +"(9"+ str1 +')' +'-'+ str2 +'-' + str3 + '-' + str4;
    }

    public void setRandomPost(File postFile) throws Exception {
        ArrayList<String> postList = getList(postFile);
        Random r =  new Random();
         this.post = postList.get(r.nextInt(postList.size()));
    }

    public void setRandomSalary() {
        Random r =  new Random();
        this.salary = String.valueOf(20000 + r.nextInt(120000));
    }

    public void setRandomExperience() {
        Random r =  new Random();
        this.experience = String.valueOf(r.nextInt(15));
    }

    public void setRandomBonusSalary() {
        Random r =  new Random();
        this.bonusSalary = String.valueOf(1000 * Integer.parseInt(this.experience));
    }

    public void setRandomOperatingMode() {
        Random r =  new Random();
        String operatingMode = "Стандартный, Сокращённый, Гибкий, Сменный, Неполный рабочий день, по графику";
        String[] operatingModeArr = operatingMode.split(", ");
        this.operatingMode = operatingModeArr[r.nextInt(operatingModeArr.length)];
    }


    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(String bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public String getOperatingMode() {
        return operatingMode;
    }

    public void setOperatingMode(String operatingMode) {
        this.operatingMode = operatingMode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                "fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", post='" + post + '\'' +
                ", salary='" + salary + '\'' +
                ", experience='" + experience + '\'' +
                ", bonusSalary='" + bonusSalary + '\'' +
                ", operatingMode='" + operatingMode + '\'' +
                '}';
    }
}
