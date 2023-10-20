package org.example;

import org.example.entity.Car;

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


        File file = new File("src/main/java/org/example/carModels.txt");

        Random r = new Random();

        for (int i = 0; i < 1000; i++) {
            Car car = new Car("", "", "", "");
            car.setRandomVin();
            car.setRandomNumber();
            car.setRandomBrand(file);
            car.setRandomReleaseDate();
            System.out.println(car);
        }


    }
}
