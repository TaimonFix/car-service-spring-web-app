package org.example.entity;

public class Employee {

    private int employeeID;
    private String fullName;
    private String birthDate;
    private String address;
    private String phone;
    private String post;
    private String salary;
    private String experience;
    private String bonusSalary;
    private String operatingMode;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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
                "employeeID=" + employeeID +
                ", fullName='" + fullName + '\'' +
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
