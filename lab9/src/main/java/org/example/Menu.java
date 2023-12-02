package org.example;

import java.util.Scanner;

public class Menu {
    public Menu() {
    }

    public static int showMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Print all list\n" +
                "2 - Print list of departments by number of employees\n" +
                "3 - Print e-mail address of the specified department\n" +
                "-----------------------------------------------------\n" +
                "4 - Saving one object in the database\n" +
                "5 - Getting all objects from the database\n" +
                "6 - Getting one object with the given id\n" +
                "7 - Updating object data in the database\n" +
                "8 - Deleting an object from the database\n" +
                "9 - Deleting an object from the database by ID\n");
        return scan.nextInt();
    }
}
