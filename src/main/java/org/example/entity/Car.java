package org.example.entity;

import java.util.Objects;

public class Car {

    private String vin;
    private String carNumber;
    private String carBrand;
    private String releaseDate;

    public Car(String vin, String carNumber, String carBrand, String releaseDate) {
        this.vin = vin;
        this.carNumber = carNumber;
        this.carBrand = carBrand;
        this.releaseDate = releaseDate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
