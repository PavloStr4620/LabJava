package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;


public class StudentMenu {
    private StudentManager studentManager;

    public StudentMenu() {
        studentManager = new StudentManager();
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;

        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Додати студента");
            System.out.println("2. Видалити студента");
            System.out.println("3. Знайти студента за ID");
            System.out.println("4. Вивести всіх студентів");
            System.out.println("5. Зберегти в файл");
            System.out.println("6. Завантажити з файлу");
            System.out.println("7. Студенти заданого факультету");
            System.out.println("8. Студенти, які народились після заданого року");
            System.out.println("9. Студенти навчальної групи");
            System.out.println("10. Вихід");
            System.out.print("Виберіть опцію: ");

            try {
                String input = reader.readLine();

                switch (input) {
                    case "1":
                        addStudent(reader);
                        break;
                    case "2":
                        removeStudent(reader);
                        break;
                    case "3":
                        findStudentById(reader);
                        break;
                    case "4":
                        printAllStudents();
                        break;
                    case "5":
                        saveToFile(reader);
                        break;
                    case "6":
                        loadFromFile(reader);
                        break;
                    case "7":
                        getStudentsByFaculty(reader);
                        break;
                    case "8":
                        getStudentsBornAfterYear(reader);
                        break;
                    case "9":
                        getStudentsByGroup(reader);
                        break;
                    case "10":
                        exit = true;
                        break;

                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addStudent(BufferedReader reader) throws IOException {
        System.out.print("Введіть ID: ");
        int id = Integer.parseInt(reader.readLine());
        System.out.print("Прізвище: ");
        String lastName = reader.readLine();
        System.out.print("Ім'я: ");
        String firstName = reader.readLine();
        System.out.print("По батькові: ");
        String middleName = reader.readLine();
        System.out.print("Дата народження (рррр-мм-дд): ");
        LocalDate dateOfBirth = LocalDate.parse(reader.readLine());
        System.out.print("Адреса: ");
        String address = reader.readLine();
        System.out.print("Телефон: ");
        String phoneNumber = reader.readLine();
        System.out.print("Факультет: ");
        String faculty = reader.readLine();
        System.out.print("Курс: ");
        int course = Integer.parseInt(reader.readLine());
        System.out.print("Група: ");
        String group = reader.readLine();

        Student student = new Student(id, lastName, firstName, middleName, dateOfBirth, address, phoneNumber, faculty, course, group);
        studentManager.addStudent(student);
    }

    private void removeStudent(BufferedReader reader) throws IOException {
        System.out.print("Введіть ID студента, якого бажаєте видалити: ");
        int id = Integer.parseInt(reader.readLine());
        studentManager.removeStudent(id);
    }

    private void findStudentById(BufferedReader reader) throws IOException {
        System.out.print("Введіть ID студента, якого бажаєте знайти: ");
        int id = Integer.parseInt(reader.readLine());
        Student student = studentManager.findStudentById(id);
        if (student != null) {
            student.printStudentInfo();
        } else {
            System.out.println("Студент не знайдений.");
        }
    }

    private void printAllStudents() {
        studentManager.printAllStudents();
    }


    private void getStudentsByFaculty(BufferedReader reader) throws IOException {
        System.out.print("Введіть факультет: ");
        String faculty = reader.readLine();
        List<Student> students = studentManager.getStudentsByFaculty(faculty);
        if (!students.isEmpty()) {
            for (Student student : students) {
                student.printStudentInfo();
            }
        } else {
            System.out.println("Студентів з цього факультету немає.");
        }
    }

    private void getStudentsBornAfterYear(BufferedReader reader) throws IOException {
        System.out.print("Введіть рік: ");
        int year = Integer.parseInt(reader.readLine());
        List<Student> students = studentManager.getStudentsBornAfterYear(year);
        if (!students.isEmpty()) {
            for (Student student : students) {
                student.printStudentInfo();
            }
        } else {
            System.out.println("Студентів, які народились після заданого року, немає.");
        }
    }

    private void getStudentsByGroup(BufferedReader reader) throws IOException {
        System.out.print("Введіть навчальну групу: ");
        String group = reader.readLine();
        List<Student> students = studentManager.getStudentsByGroup(group);
        if (!students.isEmpty()) {
            for (Student student : students) {
                student.printStudentInfo();
            }
        } else {
            System.out.println("Студентів з цієї навчальної групи немає.");
        }
    }
    private void saveToFile(BufferedReader reader) throws IOException {
        System.out.print("Введіть ім'я файлу для збереження: ");
        String filename = reader.readLine();
        studentManager.saveToFile(filename);
    }

    private void loadFromFile(BufferedReader reader) throws IOException {
        System.out.print("Введіть ім'я файлу для завантаження: ");
        String filename = reader.readLine();
        studentManager.loadFromFile(filename);
    }

    public static void main(String[] args) {
        StudentMenu menu = new StudentMenu();
        menu.run();
    }
}