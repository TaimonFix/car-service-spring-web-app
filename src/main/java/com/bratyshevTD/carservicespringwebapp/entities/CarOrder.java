package com.bratyshevTD.carservicespringwebapp.entities;

import java.math.BigInteger;

public class CarOrder {

    private long orderID;
    private int clientID;
    private String vin;
    private String orderDate;
    private String correctionDate;
    private String reason;
    private int detailID;
    private int employeeID;

    public CarOrder(long orderID, int clientID, String vin, String orderDate, String correctionDate, String reason, int detailID, int employeeID) {
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

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCorrectionDate() {
        return correctionDate;
    }

    public void setCorrectionDate(String correctionDate) {
        this.correctionDate = correctionDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
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
