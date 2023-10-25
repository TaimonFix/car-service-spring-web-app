package org.example.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Employee {
    private String fullName;
    private String birthDate;
    private String address;
    private String phone;
    private String post;
    private String salary;
    private String experience;
    private String bonusSalary;
    private String operatingMode;

    Random r =  new Random();

    public Employee(String fullName, String birthDate, String address,
                    String phone, String post, String salary, String experience,
                    String bonusSalary, String operatingMode) {
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

        this.fullName = surnameList.get(r.nextInt(surnameList.size())) +" "+
                nameList.get(r.nextInt(nameList.size())) +" "+
                patronymicList.get(r.nextInt(patronymicList.size()));
    }

    public void setRandomBirthDate() {
        String day = String.valueOf(1 + r.nextInt(30));
        String month = String.valueOf(1 + r.nextInt(12));
        String year = String.valueOf(1950 + r.nextInt(44));

        if (day.length() == 1) {
            day = "0" + day;
        }

        if (month.length() == 1) {
            month = "0" + month;
        }

        this.birthDate = day + "." + month + "." + year;
    }

    public void setRandomAddress(File cityFile, File streetFile) throws Exception{
        ArrayList<String> cityList = getList(cityFile);
        ArrayList<String> streetList = getList(streetFile);

        String city = cityList.get(r.nextInt(cityList.size()));
        String street = streetList.get(r.nextInt(streetList.size()));
        String home = String.valueOf(r.nextInt(150));

        this.address = "г." + city + "," + street + ", д." + home;
    }

    public void setRandomPhone() {
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
         this.post = postList.get(r.nextInt(postList.size()));
    }

    public void setRandomSalary() {
        this.salary = String.valueOf(20000 + r.nextInt(120000));
    }

    public void setRandomExperience() {
         this.experience = String.valueOf(r.nextInt(15));
    }

    public void setRandomBonusSalary() {
         this.bonusSalary = String.valueOf(1000 * Integer.parseInt(this.experience));
    }

    public void setRandomOperatingMode() {
        String operatingMode = "Стандартный, Сокращённый, Гибкий, Сменный, Неполный рабочий день, по графику";
        String[] operatingModeArr = operatingMode.split(", ");
        this.operatingMode = operatingModeArr[r.nextInt(operatingModeArr.length)];
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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
