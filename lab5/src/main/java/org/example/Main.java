package org.example;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        List<Student> students = fillTestStudents();

        int menuChoice;
        while ((menuChoice = menu()) != 0) {
            switch (menuChoice) {
                case 1:
                    for (Student st : students) {
                        studentManager.addStudent(st);
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    int id = scanner.nextInt();
                    studentManager.removeStudent(id);
                    break;
                case 3:
                    System.out.print("Enter text file name to save data: ");
                    String textFileName = scanner.nextLine();
                    studentManager.saveToFileText(textFileName);
                    break;
                case 4:
                    System.out.print("Enter text file name to load data: ");
                    String loadTextFileName = scanner.nextLine();
                    studentManager.loadFromFileText(loadTextFileName);
                    studentManager.printStudents();
                    break;
                case 5:
                    System.out.print("Enter binary file name to save data: ");
                    String binaryFileName = scanner.nextLine();
                    studentManager.saveToFileBinary(binaryFileName);
                    break;
                case 6:
                    System.out.print("Enter binary file name to load data: ");
                    String loadBinaryFileName = scanner.nextLine();
                    studentManager.loadFromFileBinary(loadBinaryFileName);
                    studentManager.printStudents();
                    break;
                case 7:
                    System.out.print("Enter faculty to get students: ");
                    String faculty = scanner.nextLine();
                    students.clear();
                    students = studentManager.getStudentsByFaculty(faculty);
                    studentManager.printStudents(students);
                    break;
                case 8:
                    System.out.print("Enter year to filter students born after: ");
                    int birthYear = scanner.nextInt();
                    students.clear();
                    students = studentManager.getStudentsBornAfterYear(birthYear);
                    studentManager.printStudents(students);
                    break;
                case 9:
                    System.out.print("Enter group to get students: ");
                    String group = scanner.nextLine();
                    students.clear();
                    students = studentManager.getStudentsByGroup(group);
                    studentManager.printStudents(students);
                    break;


                default:
                    System.out.println("Invalid menuChoice. Please try again.");
            }
        }
    }

    public static final int menu() {
        System.out.println("Menu:");
        System.out.println("1. Add student");
        System.out.println("2. Remove student");
        System.out.println("3. Save to text file");
        System.out.println("4. Load from text file");
        System.out.println("5. Save to binary file");
        System.out.println("6. Load from binary file");
        System.out.println("7. Students from faculty");
        System.out.println("8. Students born after");
        System.out.println("9. Get students from one group");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static final List<Student> fillTestStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Мельник", "Олена", "Ігорівна", LocalDate.of(2001, 9, 8),
                "Запоріжжя, вул. Степова, 345", "+380996789012", "Факультет 1", 2, "Група 2"));

        students.add(new Student(2, "Козлов", "Артем", "Олексійович", LocalDate.of(2004, 7, 12),
                "Кривий Ріг, вул. Промислова, 678", "+380977890123", "Факультет 3", 1, "Група 1"));

        students.add(new Student(3, "Павленко", "Ірина", "Петрівна", LocalDate.of(2000, 3, 25),
                "Чернігів, вул. Садова, 901", "+380998901234", "Факультет 2", 3, "Група 3"));

        students.add(new Student(4, "Лисенко", "Віталій", "Вікторович", LocalDate.of(1998, 6, 14),
                "Суми, вул. Лісова, 123", "+380979012345", "Факультет 1", 2, "Група 2"));

        students.add(new Student(5, "Бондаренко", "Дмитро", "Валентинович", LocalDate.of(2002, 11, 5),
                "Івано-Франківськ, вул. Гірська, 456", "+380991112233", "Факультет 3", 1, "Група 1"));

        return students;
    }
}