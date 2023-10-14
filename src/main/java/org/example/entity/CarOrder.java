package org.example.entity;

import java.math.BigInteger;

public class CarOrder {

    private BigInteger orderID;
    private int clientID;
    private String vin;
    private String orderDate;
    private String correctionDate;
    private String reason;
    private int detailID;
    private int employeeID;

    public BigInteger getOrderID() {
        return orderID;
    }

    public void setOrderID(BigInteger orderID) {
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
