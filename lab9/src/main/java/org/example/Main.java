package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "1234";

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Scanner scan = new Scanner(System.in);
                DepartmentDAO departmentsDao = new DepartmentDAO(connection);
                boolean exit = true;
                while (exit) {
                    int number = Menu.showMenu();
                    switch (number) {
                        case 1:
                            List<Departments> listNameAndManagers = departmentsDao.nameAndManagers();
                            for (Departments i : listNameAndManagers) {
                                System.out.println("name=" + i.getName() + ", manager=" + i.getManager());
                            }
                            System.out.println();
                            break;

                        case 2:
                            System.out.print("Enter number employees to search: ");
                            List<Departments> departmentSearchNumberOfEmployees = departmentsDao.searchNumberOfEmployees(scan.nextInt());
                            for (Departments j : departmentSearchNumberOfEmployees) {
                                System.out.println(j);
                            }
                            break;

                        case 3:
                            System.out.print("get the e-mail address of the specified department: ");
                            Departments departmentsSearchEmail = departmentsDao.getEmailTheNameDepartment(scan.next());
                            System.out.println("email = " + departmentsSearchEmail.getEmailAddress());
                            break;

                        case 4:
                            System.out.print("\nEnter name:");
                            String name = scan.next();

                            System.out.print("\nEnter manager:");
                            String manager = scan.next();

                            System.out.print("\nEnter date Creation Department:");
                            String dateCreationDepartment = scan.next();

                            System.out.print("\nEnter number Employees:");
                            int numberEmployees = scan.nextInt();

                            System.out.print("\nEnter projects:");
                            String projects = scan.next();

                            System.out.print("\nEnter phone Number:");
                            String phoneNumber = scan.next();

                            System.out.print("\nEnter email Address:");
                            String emailAddress = scan.next();

                            Departments departments = new Departments(name, manager, dateCreationDepartment, numberEmployees, projects, phoneNumber, emailAddress);

                            int countInsertRows = departmentsDao.insert(departments);

                            if (countInsertRows == 1) {
                                System.out.println("Rows insert - " + countInsertRows + '\n');
                            } else {
                                System.err.println("Unable to insert");
                            }
                            break;

                        case 5:
                            List<Departments> allDepartments = departmentsDao.select();
                            for (Departments i : allDepartments) {
                                System.out.println(i);
                            }
                            System.out.println();
                            break;

                        case 6:
                            System.out.print("Enter id to search: ");
                            Departments departmentsSearchId = departmentsDao.findById(scan.nextInt());
                            System.out.println(departmentsSearchId);
                            break;

                        case 7:
                            System.out.print("\nEnter id:");
                            int idUpdate = scan.nextInt();

                            System.out.print("\nEnter name:");
                            String nameUpdate = scan.next();

                            System.out.print("\nEnter manager:");
                            String managerUpdate = scan.next();

                            System.out.print("\nEnter date Creation Department:");
                            String dateCreationDepartmentUpdate = scan.next();

                            System.out.print("\nEnter number Employees:");
                            int numberEmployeesUpdate = scan.nextInt();

                            System.out.print("\nEnter projects:");
                            String projectsUpdate = scan.next();

                            System.out.print("\nEnter phone Number:");
                            String phoneNumberUpdate = scan.next();

                            System.out.print("\nEnter email Address:");
                            String emailAddressUpdate = scan.next();

                            Departments departmentsUpdate = new Departments(idUpdate, nameUpdate, managerUpdate, dateCreationDepartmentUpdate, numberEmployeesUpdate, projectsUpdate, phoneNumberUpdate, emailAddressUpdate);
                            int update = departmentsDao.update(departmentsUpdate);

                            if (update == 1) {
                                System.out.println("Rows update - " + update + '\n');
                            } else {
                                System.err.println("Unable to update");
                            }
                            break;

                        case 8:
                            int delete = 0;
                            System.out.print("\nEnter name:");
                            String nameDelete = scan.next();

                            System.out.print("\nEnter manager:");
                            String managerDelete = scan.next();

                            System.out.print("\nEnter date Creation Department:");
                            String dateCreationDepartmentDelete = scan.next();

                            System.out.print("\nEnter number Employees:");
                            int numberEmployeesDelete = scan.nextInt();

                            System.out.print("\nEnter projects:");
                            String projectsDelete = scan.next();

                            System.out.print("\nEnter phone Number:");
                            String phoneNumberDelete = scan.next();

                            System.out.print("\nEnter email Address:");
                            String emailAddressDelete = scan.next();

                            Departments departmentsDelete = new Departments(nameDelete, managerDelete, dateCreationDepartmentDelete, numberEmployeesDelete, projectsDelete, phoneNumberDelete, emailAddressDelete);
                            delete = departmentsDao.delete(departmentsDelete);

                            if (delete == 1) {
                                System.out.println("Rows delete - " + delete + '\n');
                            } else {
                                System.err.println("Failed to delete data");
                            }
                            break;

                        case 9:
                            System.out.print("Enter id to delete: ");
                            int deleteId = departmentsDao.deleteById(scan.nextInt());

                            if (deleteId == 1) {
                                System.out.println("Rows delete - " + deleteId + '\n');
                            } else {
                                System.err.println("Failed to delete data");
                            }
                            break;

                        default:
                            exit = false;
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }
}