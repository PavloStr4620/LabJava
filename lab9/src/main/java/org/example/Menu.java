//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.util.Scanner;

public class Menu {
    public Menu() {
    }

    public static int showMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Print all list\n2 - Print list of departments by number of employees\n3 - Print e-mail address of the specified department\n-----------------------------------------------------\n4 - Saving one object in the database\n5 - Getting all objects from the database\n6 - Getting one object with the given id\n7 - Updating object data in the database\n8 - Deleting an object from the database\n9 - Deleting an object from the database by ID\n");
        return scan.nextInt();
    }
}
