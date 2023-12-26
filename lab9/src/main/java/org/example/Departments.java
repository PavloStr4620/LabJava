package org.example;
public class Departments {
    private int id;
    private String name;
    private String manager;
    private String dateCreationDepartment;
    private int numberEmployees;
    private String projects;
    private String phoneNumber;
    private String emailAddress;

    public Departments(String name, String manager, String dateCreationDepartment, int numberEmployees, String projects, String phoneNumber, String emailAddress) {
        this.name = name;
        this.manager = manager;
        this.dateCreationDepartment = dateCreationDepartment;
        this.numberEmployees = numberEmployees;
        this.projects = projects;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Departments(int id, String name, String manager, String dateCreationDepartment, int numberEmployees, String projects, String phoneNumber, String emailAddress) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.dateCreationDepartment = dateCreationDepartment;
        this.numberEmployees = numberEmployees;
        this.projects = projects;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Departments() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return this.manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDateCreationDepartment() {
        return this.dateCreationDepartment;
    }

    public void setDateCreationDepartment(String dateCreationDepartment) {
        this.dateCreationDepartment = dateCreationDepartment;
    }

    public int getNumberEmployees() {
        return this.numberEmployees;
    }

    public void setNumberEmployees(int numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public String getProjects() {
        return this.projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String toString() {
        return "name= " + this.name + ", manager=" + this.manager + "', dateCreationDepartment=" + this.dateCreationDepartment + ", numberEmployees=" + this.numberEmployees + ", projects=" + this.projects + ", phoneNumber=" + this.phoneNumber + ", emailAddress=" + this.emailAddress + "}";
    }
}
