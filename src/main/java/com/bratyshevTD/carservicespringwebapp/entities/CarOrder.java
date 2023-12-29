package com.bratyshevTD.carservicespringwebapp.entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="car-order")
public class CarOrder {

    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client clientID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vin")
    private Car vin;
    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name="correction_date")
    private LocalDate correctionDate;

    @Column(name="reason")
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id")
    private CarDetail detailID;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private List<Employee> employeeID;

    public CarOrder(long orderID, Client clientID, Car vin, LocalDate orderDate, LocalDate correctionDate, String reason, CarDetail detailID, List<Employee> employeeID) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.vin = vin;
        this.orderDate = orderDate;
        this.correctionDate = correctionDate;
        this.reason = reason;
        this.detailID = detailID;
        this.employeeID = employeeID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    public Car getVin() {
        return vin;
    }

    public void setVin(Car vin) {
        this.vin = vin;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getCorrectionDate() {
        return correctionDate;
    }

    public void setCorrectionDate(LocalDate correctionDate) {
        this.correctionDate = correctionDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CarDetail getDetailID() {
        return detailID;
    }

    public void setDetailID(CarDetail detailID) {
        this.detailID = detailID;
    }

    public List<Employee> getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(List<Employee> employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "CarOrder{" +
                "orderID=" + orderID +
                ", clientID=" + clientID +
                ", vin='" + vin + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", correctionDate='" + correctionDate + '\'' +
                ", reason='" + reason + '\'' +
                ", detailID=" + detailID +
                ", employeeID=" + employeeID +
                '}';
    }
}
