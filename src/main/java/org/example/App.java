package org.example;

import org.example.entity.Car;
import org.example.entity.CarDetail;
import org.example.entity.Client;
import org.example.entity.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        System.out.println("Hello World!");


        File carModelsFile = new File("src/main/java/org/example/testData/car/carModels.txt");
        File carDetailsFile = new File("src/main/java/org/example/testData/car/carDetails.txt");

        Random r = new Random();

//        for (int i = 0; i < 1000; i++) {
//            Car car = new Car("", "", "", "");
//            car.setRandomVin();
//            car.setRandomNumber();
//            car.setRandomBrand(carModelsFile);
//            car.setRandomReleaseDate();
//            System.out.println(car);
//        }

        CarDetail carDetail = new CarDetail("", "");

        for (int i = 0; i < 67; i++) {
            carDetail.setRandomDetailID();
            carDetail.setRandomTitle(carDetailsFile);
            System.out.println(carDetail);
        }

        Client client = new Client("", "");
        File surnameFile = new File("src/main/java/org/example/testData/fullName/surnames.txt");
        File nameFile = new File("src/main/java/org/example/testData/fullName/names.txt");
        File patronymicFile = new File("src/main/java/org/example/testData/fullName/patronymic.txt");
        for (int i = 0; i < 67; i++) {
            client.setRandomFullName(surnameFile, nameFile, patronymicFile);
            client.setRandomPhone();
            System.out.println(client);
        }

        File cityFile = new File("src/main/java/org/example/testData/address/city.txt");
        File streetFile = new File("src/main/java/org/example/testData/address/street.txt");
        File postFile = new File("src/main/java/org/example/testData/post.txt");
        Employee employee = new Employee("", "", "",
                                            "", "", "", "",
                                        "", "");

        for (int i = 0; i < 67; i++) {
            employee.setRandomFullName(surnameFile, nameFile, patronymicFile);
            employee.setRandomBirthDate();
            employee.setRandomAddress(cityFile, streetFile);
            employee.setRandomPhone();
            employee.setRandomPost(postFile);
            employee.setRandomSalary();
            employee.setRandomExperience();
            employee.setRandomBonusSalary();
            employee.setRandomOperatingMode();
            System.out.println(employee);
        }

    }
}
