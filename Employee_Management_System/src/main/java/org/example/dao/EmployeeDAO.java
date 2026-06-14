package org.example.dao;

import java.sql.ResultSet;
import org.example.model.Employee;
import org.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Handles database operations for employees.
 */
public class EmployeeDAO {

    /**
     * Creates the employees table if it does not exist.
     */
    public void createTable() {
        String query =
                "CREATE TABLE IF NOT EXISTS employees (" +
                        "id INT PRIMARY KEY, " +
                        "name VARCHAR(100), " +
                        "department VARCHAR(100), " +
                        "salary DOUBLE)";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.execute();

            System.out.println("Employees table ready.");

        } catch (SQLException e) {

            System.out.println("Error creating table: "
                    + e.getMessage());
        }
    }
    /**
     * Adds a new employee to the database.
     *
     * @param employee employee object to insert
     */
    public void addEmployee(Employee employee) {

        String query =
                "INSERT INTO employees (id, name, department, salary) " +
                        "VALUES (?, ?, ?, ?)";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee added successfully.");
            }

        } catch (SQLException e) {

            System.out.println("Error adding employee: "
                    + e.getMessage());
        }
    }
    /**
     * Displays all employees from the database.
     */
    public void viewEmployees() {

        String query = "SELECT * FROM employees";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            System.out.println("--------------------------------------------------------");
            System.out.printf("%-8s %-15s %-20s %-10s%n",
                    "ID", "Name", "Department", "Salary");
            System.out.println("--------------------------------------------------------");

            boolean found = false;

            while (resultSet.next()) {

                found = true;

                System.out.printf(
                        "%-8d %-15s %-20s %-10.2f%n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary")
                );
            }

            if (!found) {
                System.out.println("No employee records found.");
            }

            System.out.println("--------------------------------------------------------");

        } catch (SQLException e) {

            System.out.println(
                    "Error fetching employees: "
                            + e.getMessage()
            );
        }
    }
    /**
     * Updates the salary of an employee.
     *
     * @param id employee ID
     * @param newSalary updated salary
     */
    public void updateEmployeeSalary(int id, double newSalary) {

        String query =
                "UPDATE employees SET salary = ? WHERE id = ?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setDouble(1, newSalary);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee salary updated successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error updating employee: "
                            + e.getMessage()
            );
        }
    }
    /**
     * Deletes an employee from the database.
     *
     * @param id employee ID
     */
    public void deleteEmployee(int id) {

        String query =
                "DELETE FROM employees WHERE id = ?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting employee: "
                            + e.getMessage()
            );
        }
    }
}
