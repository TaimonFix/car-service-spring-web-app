package com.bratyshevTD.carservicespringwebapp;

import com.bratyshevTD.carservicespringwebapp.entities.CarDetail;
import com.bratyshevTD.carservicespringwebapp.entities.Client;
import com.bratyshevTD.carservicespringwebapp.entities.Employee;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

/**
 * Hello world!
 *
 */
public class TestData
{
    public static void main( String[] args ) throws Exception {


//        File carModelsFile = new File("testData/car/carModels.txt");
//        File carDetailsFile = new File("testData/car/carDetails.txt");
//
//        Random r = new Random();
//
////        for (int i = 0; i < 1000; i++) {
////            Car car = new Car("", "", "", "");
////            car.setRandomVin();
////            car.setRandomNumber();
////            car.setRandomBrand(carModelsFile);
////            car.setRandomReleaseDate();
////            System.out.println(car);
////        }
//
//        CarDetail carDetail = new CarDetail("", "");
//
//        for (int i = 0; i < 67; i++) {
//            carDetail.setRandomDetailID();
//            carDetail.setRandomTitle(carDetailsFile);
//            System.out.println(carDetail);
//        }
//
//        Client client = new Client(1, "", "");
//        File surnameFile = new File("testData/fullName/surnames.txt");
//        File nameFile = new File("testData/fullName/names.txt");
//        File patronymicFile = new File("testData/fullName/patronymic.txt");
//        for (int i = 0; i < 67; i++) {
//            client.setRandomFullName(surnameFile, nameFile, patronymicFile);
//            client.setRandomPhone();
//            System.out.println(client);
//        }
//
//        File cityFile = new File("testData/address/city.txt");
//        File streetFile = new File("testData/address/street.txt");
//        File postFile = new File("testData/post.txt");
//        Employee employee = new Employee(1, "", "", "",
//                                            "", "", "", "",
//                                        "", "");
//
//        for (int i = 0; i < 67; i++) {
//            employee.setRandomFullName(surnameFile, nameFile, patronymicFile);
//            employee.setRandomBirthDate();
//            employee.setRandomAddress(cityFile, streetFile);
//            employee.setRandomPhone();
//            employee.setRandomPost(postFile);
//            employee.setRandomSalary();
//            employee.setRandomExperience();
//            employee.setRandomBonusSalary();
//            employee.setRandomOperatingMode();
//            System.out.println(employee);
//        }
//

    }
}
