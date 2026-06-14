# Employee Management System

## About the Project

This is a simple Employee Management System developed using Java, JDBC, and MySQL. The main purpose of this project is to understand how a Java application can interact with a database to store and manage data.

The application allows users to add employee details, view employee records, update employee salaries, and delete employee information. All records are stored in a MySQL database, so the data remains available even after closing the application.

This project helped me understand how Java and databases work together in real-world applications.

---

## Features

* Add a new employee
* View all employee records
* Update employee salary
* Delete an employee record
* Store employee data in MySQL database
* Automatically create the employee table if it does not exist
* Menu-driven console application
* Uses JDBC for database connectivity

---

## Technologies Used

* Java
* JDBC (Java Database Connectivity)
* MySQL
* Maven
* IntelliJ IDEA

---

## Project Structure

```text
src/main/java/org/example
│
├── model
│   └── Employee.java
│
├── dao
│   └── EmployeeDAO.java
│
├── util
│   └── DatabaseConnection.java
│
└── Main.java
```

---

## Database Details

### Database Name

```sql
employee_db
```

### Table Name

```sql
employees
```

### Table Fields

| Column     | Data Type |
| ---------- | --------- |
| id         | INT       |
| name       | VARCHAR   |
| department | VARCHAR   |
| salary     | DOUBLE    |

---

## How to Run the Project

1. Make sure MySQL Server is installed and running.
2. Create a database named:

```sql
CREATE DATABASE employee_db;
```

3. Open the project in IntelliJ IDEA.
4. Add your MySQL username and password in `DatabaseConnection.java`.
5. Run the `Main.java` file.
6. Use the menu options to perform different operations.

---

## Sample Menu

```text
===== EMPLOYEE MANAGEMENT SYSTEM =====

1. Add Employee
2. View Employees
3. Update Employee Salary
4. Delete Employee
5. Exit

Enter your choice:
```

---

## Sample Output

```text
--------------------------------------------------------
ID       Name            Department           Salary
--------------------------------------------------------
1        RIYA            SALES                55000.00
2        SIYA            MARKETING            50000.00
--------------------------------------------------------
```

---

## Concepts Used

While building this project, I practiced the following concepts:

* Object-Oriented Programming (OOP)
* Classes and Objects
* Encapsulation
* JDBC Connectivity
* MySQL Database Operations
* CRUD Operations
* PreparedStatement
* ResultSet
* Exception Handling
* Maven Dependency Management

---

## Learning Outcome

This project helped me understand how Java applications communicate with databases using JDBC. I learned how to perform CRUD operations, write SQL queries from Java, manage database connections, and organize code using the DAO pattern.

It was a great hands-on experience in building a simple database-driven application using Java and MySQL.
