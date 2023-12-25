package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);

    }

    public void saveToFileText(String fileName) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (Student student : students) {
                writer.println(student.getId() + "_" + student.getLastName() + "_" + student.getFirstName() + "_" +
                        student.getMiddleName() + "_" + student.getDateOfBirth() + "_" + student.getAddress() + "_" +
                        student.getPhoneNumber() + "_" + student.getFaculty() + "_" + student.getCourse() + "_" + student.getGroup());
            }
        } catch (IOException e) {
            System.err.println("Error while saving data to the text file: " + e.getMessage());
        }
    }

    public void loadFromFileText(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("_");
                int id = Integer.parseInt(parts[0]);

                String lastName = parts[1];
                String firstName = parts[2];
                String middleName = parts[3];
                LocalDate dateOfBirth = LocalDate.parse(parts[4]);
                String address = parts[5];
                String phoneNumber = parts[6];
                String faculty = parts[7];
                int course = Integer.parseInt(parts[8]);
                String group = parts[9];

                Student student = new Student(id, lastName, firstName, middleName, dateOfBirth, address, phoneNumber, faculty, course, group);
                students.add(student);
            }
        } catch (IOException e) {
            System.err.println("Error while loading data from the text file: " + e.getMessage());
        }
    }

    public void saveToFileBinary(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error while saving data to the binary file: " + e.getMessage());
        }
    }

    public void loadFromFileBinary(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while loading data from the binary file: " + e.getMessage());
        }
    }

    public List<Student> getStudentsByFaculty(String faculty) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equalsIgnoreCase(faculty)) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> getStudentsBornAfterYear(int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getDateOfBirth().getYear() > year) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> getStudentsByGroup(String group) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup().equalsIgnoreCase(group)) {
                result.add(student);
            }
        }
        return result;
    }

    public void printStudents(List<Student> students) {
        for (Student st : students) {
            st.printStudentInfo();
        }
    }

    public void printStudents() {
        for (Student st : students) {
            st.printStudentInfo();
        }
    }
}