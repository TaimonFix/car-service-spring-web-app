package com.bratyshevTD.carservicespringwebapp.entities;

import jakarta.persistence.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "car")

public class Car {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "vin")
    private String vin;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "car_brand")
    private String carBrand;

    @Column(name = "release_date")
    private Date releaseDate;

    public Car() {
    }

    public Car(String vin, String carNumber, String carBrand, Date releaseDate) {
        this.vin = vin;
        this.carNumber = carNumber;
        this.carBrand = carBrand;
        this.releaseDate = releaseDate;
    }

    public void setRandomVin() {
        Random r = new Random();
        String[] arr = new String[17];

        for (int i = 0; i < arr.length; i++) {
            if ((i <= 2) || (i == 9)) {
                arr[i] = String.valueOf((char)(r.nextInt(26) + 'A'));
            }
            else {
                arr[i] = String.valueOf((char) (r.nextInt(9) + '1'));
            }
        }

        String vin = "";

        for (String c: arr) {
            vin += c;
        }

        this.vin = vin;
    }

    public void setRandomNumber() {
        Random r = new Random();
        String[] arr = new String[8];

        for (int i = 0; i < arr.length; i++) {
            if ((i == 0) || (i == 4) || (i == 5)) {
                arr[i] = String.valueOf((char)(r.nextInt(26) + 'A'));
            }
            else {
                arr[i] = String.valueOf((char)(r.nextInt(9) + '1'));
            }
        }

        String carNumber = "";

        for (String c: arr) {
            carNumber += c;
        }

        this.carNumber = carNumber;
    }

    public void setRandomBrand(File file) throws Exception {
        ArrayList<String> carModelsList = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            carModelsList.add(bufferedReader.readLine());
        }

        Random r = new Random();

        this.carBrand = carModelsList.get(r.nextInt(carModelsList.size()));
    }

//    public void setRandomReleaseDate() {
//Random r = new Random();
//        String day = String.valueOf(1 + r.nextInt(30));
//        String month    = String.valueOf(1 + r.nextInt(12));
//        String year = String.valueOf(2000 + r.nextInt(24));
//
//        if (day.length() == 1) {
//            day = "0" + day;
//        }
//
//        if (month.length() == 1) {
//            month = "0" + month;
//        }
//
//        this.releaseDate = day + "." + month + "." + year;
//    }

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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
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
