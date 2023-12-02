package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    List<Departments> nameAndManagers() {
        String select = "SELECT name, manager FROM department";
        List<Departments> getAllDepartment = new ArrayList();
        Departments departments = new Departments();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(select)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                departments.setName(resultSet.getString("name"));
                departments.setManager(resultSet.getString("manager"));
                getAllDepartment.add(departments);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getAllDepartment;
    }

    List<Departments> searchNumberOfEmployees(int numberOfEmployees) {
        String request = "SELECT * FROM department WHERE employee_count >= ?;";
        List<Departments> getAllNumberOfEmployees = new ArrayList();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(request)) {


            preparedStatement.setInt(1, numberOfEmployees);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Departments departments = new Departments();
                departments.setId(resultSet.getInt("id"));
                departments.setName(resultSet.getString("name"));
                departments.setManager(resultSet.getString("manager"));
                departments.setDateCreationDepartment(resultSet.getString("creation_date"));
                departments.setNumberEmployees(resultSet.getInt("employee_count"));
                departments.setProjects(resultSet.getString("tasks_projects"));
                departments.setPhoneNumber(resultSet.getString("phone_number"));
                departments.setEmailAddress(resultSet.getString("email"));
                getAllNumberOfEmployees.add(departments);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getAllNumberOfEmployees;
    }

    Departments getEmailTheNameDepartment(String NameDepartment) {
        String request = "SELECT * FROM department WHERE name = ?;";
        Departments departments = new Departments();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(request)) {

            preparedStatement.setString(1, NameDepartment);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                departments.setEmailAddress(resultSet.getString("email"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    public int insert(Departments departments) {
        int insertRowsCount = 0;
        String request = "INSERT INTO department (name, manager, creation_date, employee_count, tasks_projects, phone_number, email) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(request);

            try {
                preparedStatement.setString(1, departments.getName());
                preparedStatement.setString(2, departments.getManager());
                preparedStatement.setString(3, departments.getDateCreationDepartment());
                preparedStatement.setInt(4, departments.getNumberEmployees());
                preparedStatement.setString(5, departments.getProjects());
                preparedStatement.setString(6, departments.getPhoneNumber());
                preparedStatement.setString(7, departments.getEmailAddress());
                insertRowsCount = preparedStatement.executeUpdate();
            } catch (Throwable var8) {
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

        return insertRowsCount;
    }

    List<Departments> select() {
        String select = "SELECT * FROM department";
        List<Departments> getAllDepartment = new ArrayList();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(select);) {


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Departments departments = new Departments();

                departments.setId(resultSet.getInt("id"));
                departments.setName(resultSet.getString("name"));
                departments.setManager(resultSet.getString("manager"));
                departments.setDateCreationDepartment(resultSet.getString("creation_date"));
                departments.setNumberEmployees(resultSet.getInt("employee_count"));
                departments.setProjects(resultSet.getString("tasks_projects"));
                departments.setPhoneNumber(resultSet.getString("phone_number"));
                departments.setEmailAddress(resultSet.getString("email"));
                getAllDepartment.add(departments);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getAllDepartment;
    }

    Departments findById(int id) {
        String request = "SELECT * FROM department WHERE id = ?;";
        Departments departments = new Departments();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(request)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                departments.setId(resultSet.getInt("id"));
                departments.setName(resultSet.getString("name"));
                departments.setManager(resultSet.getString("manager"));
                departments.setDateCreationDepartment(resultSet.getString("creation_date"));
                departments.setNumberEmployees(resultSet.getInt("employee_count"));
                departments.setProjects(resultSet.getString("tasks_projects"));
                departments.setPhoneNumber(resultSet.getString("phone_number"));
                departments.setEmailAddress(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    int update(Departments departments) {
        int updateRowsCount = 0;
        String update = "UPDATE department SET name = ?, manager = ?, creation_date = TO_DATE(?, 'YYYY-MM-DD'), employee_count = ?, tasks_projects = ?, phone_number = ?, email = ? WHERE id = ?;";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(update)) {

            preparedStatement.setString(1, departments.getName());
            preparedStatement.setString(2, departments.getManager());
            preparedStatement.setString(3, departments.getDateCreationDepartment());
            preparedStatement.setInt(4, departments.getNumberEmployees());
            preparedStatement.setString(5, departments.getProjects());
            preparedStatement.setString(6, departments.getPhoneNumber());
            preparedStatement.setString(7, departments.getEmailAddress());
            preparedStatement.setInt(8, departments.getId());
            updateRowsCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updateRowsCount;
    }

    int delete(Departments departments) {
        int deleteRowsCount = 0;
        String delete = "DELETE FROM department WHERE name = ? and manager = ? and creation_date = TO_DATE(?, 'YYYY-MM-DD') and employee_count = ? and tasks_projects = ? and phone_number = ? and email = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(delete);) {
            preparedStatement.setString(1, departments.getName());
            preparedStatement.setString(2, departments.getManager());
            preparedStatement.setString(3, departments.getDateCreationDepartment());
            preparedStatement.setInt(4, departments.getNumberEmployees());
            preparedStatement.setString(5, departments.getProjects());
            preparedStatement.setString(6, departments.getPhoneNumber());
            preparedStatement.setString(7, departments.getEmailAddress());
            deleteRowsCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleteRowsCount;
    }

    int deleteById(int id) {
        int deleteID = 0;
        String deleteId = "DELETE FROM department WHERE id=?;";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(deleteId)) {

            preparedStatement.setInt(1, id);
            deleteID = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleteID;
    }
}
