package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements Serializable {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    public Student findStudentById(int studentId) {
        return students.stream().filter(student -> student.getId() == studentId).findFirst().orElse(null);
    }

    public void printAllStudents() {
        for (Student student : students) {
            student.printStudentInfo();
        }
    }

    public void saveToFile(String filename) {
        if (filename.endsWith(".bin")) {
            saveToBinaryFile(filename);
        } else if (filename.endsWith(".txt")) {
            saveToTextFile(filename);
        } else {
            System.out.println("Невідомий тип файлу. Введіть ім'я файлу з розширенням .txt або .bin");
        }
    }

    public void loadFromFile(String filename) {
        if (filename.endsWith(".bin")) {
            loadFromBinaryFile(filename);
        } else if (filename.endsWith(".txt")) {
            loadFromTextFile(filename);
        } else {
            System.out.println("Невідомий тип файлу. Введіть ім'я файлу з розширенням .txt або .bin");
        }
    }

    public void saveToBinaryFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromBinaryFile(String filename) {
        students.clear(); // Очищення списку перед завантаженням даних

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveToTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(
                        student.getId() + "," +
                                student.getLastName() + "," +
                                student.getFirstName() + "," +
                                student.getMiddleName() + "," +
                                student.getDateOfBirth() + "," +
                                student.getAddress() + "," +
                                student.getPhoneNumber() + "," +
                                student.getFaculty() + "," +
                                student.getCourse() + "," +
                                student.getGroup()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromTextFile(String filename) {
        students.clear(); // Очищення списку перед завантаженням даних

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");

                int id = Integer.parseInt(data[0]);
                String lastName = data[1];
                String firstName = data[2];
                String middleName = data[3];
                LocalDate dateOfBirth = LocalDate.parse(data[4]);
                String address = data[5];
                String phoneNumber = data[6];
                String faculty = data[7];
                int course = Integer.parseInt(data[8]);
                String group = data[9];

                Student student = new Student(id, lastName, firstName, middleName, dateOfBirth, address, phoneNumber, faculty, course, group);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudentsByGroup(String group) {
        List<Student> studentsByGroup = new ArrayList<>();

        for (Student student : students) {
            if (student.getGroup().equalsIgnoreCase(group)) {
                studentsByGroup.add(student);
            }
        }

        return studentsByGroup;
    }

    public List<Student> getStudentsBornAfterYear(int year) {
        List<Student> studentsBornAfterYear = new ArrayList<>();

        for (Student student : students) {
            if (student.getDateOfBirth().getYear() > year) {
                studentsBornAfterYear.add(student);
            }
        }

        return studentsBornAfterYear;
    }


    public List<Student> getStudentsByFaculty(String faculty) {
        List<Student> studentsByFaculty = new ArrayList<>();

        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                studentsByFaculty.add(student);
            }
        }

        return studentsByFaculty;
    }

}