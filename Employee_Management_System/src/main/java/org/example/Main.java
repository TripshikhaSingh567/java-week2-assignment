package org.example;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();
        Scanner scanner = new Scanner(System.in);

        dao.createTable();

        boolean running = true;

        while (running) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.print("Enter Employee ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary =
                            Double.parseDouble(scanner.nextLine());

                    Employee employee =
                            new Employee(
                                    id,
                                    name,
                                    department,
                                    salary
                            );

                    dao.addEmployee(employee);

                    break;
                }
                case 2: {
                    dao.viewEmployees();
                    break;
                }
                case 3: {
                    System.out.print("Enter Employee ID: ");
                    int updateId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter New Salary: ");
                    double newSalary =
                            Double.parseDouble(scanner.nextLine());

                    dao.updateEmployeeSalary(
                            updateId,
                            newSalary
                    );
                    break;
                }
                case 4: {
                    System.out.print(
                            "Enter Employee ID to delete: "
                    );

                    int deleteId =
                            Integer.parseInt(scanner.nextLine());

                    dao.deleteEmployee(deleteId);
                    break;
                }
                case 5: {
                    System.out.println(
                            "Exiting application..."
                    );

                    running = false;
                    break;
                }
                default: {
                    System.out.println(
                            "Invalid choice."
                    );
                }
            }
        }
    }
}