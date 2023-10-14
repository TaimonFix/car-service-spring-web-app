package org.example;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        File carModels = new File("org/example/carModels");
        System.out.println(carModels.isFile());

    }
}
