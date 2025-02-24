package org.example;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int SIZE = 5;
        Department[] department = new Department[5];
        Scanner scan = new Scanner(System.in);
        department[0] = new Department(1, "Company A", "John Smith", "2020-01-15", 50, "Project X", "+123456789", "john@example.com");
        department[1] = new Department(2, "Company B", "Alice Johnson", "2019-11-30", 75, "Project Y", "+987654321", "alice@example.com");
        department[2] = new Department(3, "Company C", "Bob Brown", "2021-03-22", 30, "Project Z", "+555555555", "bob@example.com");
        department[3] = new Department(4, "Company D", "Eve Davis", "2018-08-10", 100, "Project W", "+111111111", "eve@example.com");
        department[4] = new Department(5, "Company E", "Charlie White", "2022-05-05", 60, "Project V", "+999999999", "charlie@example.com");

        label47:
        for (int menu = menuInterface(); menu != 4; menu = menuInterface()) {
            int i;
            switch (menu) {
                case 1:
                    i = 0;

                    while (true) {
                        if (i >= 5) {
                            continue label47;
                        }

                        System.out.println(department[i].toString());
                        ++i;
                    }
                case 2:
                    System.out.print("Введіть кількість співробітників: ");
                    int searchNumberEmployees = scan.nextInt();
                    i = 0;

                    while (true) {
                        if (i >= 5) {
                            continue label47;
                        }

                        if (department[i].getNumberEmployees() >= searchNumberEmployees) {
                            System.out.println(department[i].toString());
                        }

                        ++i;
                    }
                case 3:
                    System.out.print("Введіть назву відділу: ");
                    String searchName = scan.nextLine();
                    i = 0;

                    while (true) {
                        if (i >= 5) {
                            continue label47;
                        }

                        if (department[i].getName().equals(searchName)) {
                            System.out.println(department[i].getEmailAddress());
                        }

                        ++i;
                    }
                default:
                    System.out.println("Erorr");
            }
        }

    }

    public static int menuInterface() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n1-Вивести дані");
        System.out.println("2-Вивести список відділів, які мають кількість співробітників рівну чи більшу заданої кількості;");
        System.out.println("3-Електронну адресу вказаного відділу.");
        System.out.println("4-вийти");
        int menu = scan.nextInt();
        return menu;
    }
}